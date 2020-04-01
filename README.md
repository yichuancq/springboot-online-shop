# springboot-online-shop

- oauth2模块
```java
//懒加载 不会查询role表
@ManyToMany(mappedBy = "sysRoleList", fetch = FetchType.LAZY)
private List<UserInfo> userInfoList;

//角色 -- 权限关系：多对多关系;
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@ManyToMany(mappedBy = "sysRoleList", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
private List<SysPermission> permissions;
```
#####权限匹配
```java
/**
 * 是否有权限
 *
 * @param request
 * @param authentication
 * @return
 */
public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
    Object principal = authentication.getPrincipal();
    AtomicBoolean hasPermission = new AtomicBoolean(false);
    if (principal instanceof UserInfo) {
        //读取用户所拥有的权限菜单
        UserInfo userInfo = (UserInfo) principal;
        logger.info("userInfo:{}", userInfo.toString());
        //双层循环先得到角色根据角色获取权限，通过权限匹配URL
        userInfo.getSysRoleList().stream().forEach(sysRole ->
                sysRole.getPermissions().forEach(sysPermission -> {
                    if (antPathMatcher.match(sysPermission.getUrl(), request.getRequestURI())) {
                        logger.info("hasPermission:{}", hasPermission);
                        hasPermission.set(true);
                    }
                }));
    }
    logger.info("hasPermission:{}", hasPermission);
    return hasPermission.get();
}
```
#####重写方法configure
```java
//
@Override
public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable(); //注释就是使用 csrf 功能
    http.headers().frameOptions().disable();//解决 in a frame because it set 'X-Frame-Options' to 'DENY' 问题
    //http.anonymous().disable();
    http.logout().logoutUrl("/welcome");
    http.authorizeRequests()
            .antMatchers("/login/**", "/login")//不拦截登录相关方法
            .permitAll()
            .antMatchers("/welcome/**", "/welcome")//不拦截登录相关方法
            .permitAll()
            .antMatchers("/index/**", "/index")//不拦截登录相关方法
            .permitAll()
            .antMatchers("/403/**", "/403")//不拦截登录相关方法
            .permitAll()
//                .antMatchers("/userList/**", "/userList")
            //.hasRole("管理员")
            .antMatchers("/logout/**", "/logout")//不拦截登录相关方法
            .permitAll()
            .antMatchers("/loginOutSuccess/**", "/loginOutSuccess")//不拦截登录相关方法
            .permitAll()
            //.antMatchers("/user").hasRole("ADMIN")  // user接口只有ADMIN角色的可以访问
            .anyRequest()
            .authenticated()// 任何尚未匹配的URL只需要验证用户即可访问
            // swagger start
            .antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/v2/api-docs").permitAll()
            .antMatchers("/configuration/ui").permitAll()
            .antMatchers("/configuration/security").permitAll()
            //swagger end
            .anyRequest()
            .authenticated()// 任何尚未匹配的URL只需要验证用户即可访问
            .anyRequest()
            //其他所有资源都需要登陆后才能访问
            .access("@rbacPermission.hasPermission(request, authentication)")//根据账号权限访问
            .and()
            .formLogin()
            .loginPage("/login")
            .usernameParameter("username") //登录用户名参数
            .passwordParameter("password") //登录密码参数
            .successForwardUrl("/index").permitAll()
            .defaultSuccessUrl("/welcome").permitAll()
            .failureUrl("/error").permitAll()
//               /设置默认登录成功跳转页面
            .successHandler(successHandler)//登录成功处理器
            .failureHandler(customAuthenticationFailureHandler)//登录失败处理器
            .and()
            .exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler) //无权限处理器
            .and()
            .logout().logoutUrl("/logout").permitAll()
            .logoutSuccessUrl("/loginOutSuccess").permitAll()
            .and()
            .rememberMe()
//               //设置cookie有效期
            .tokenValiditySeconds(60 * 60 * 24 * 7);
}
```
- 商品模块

- 会员模块

- 销售模块

- 库存模块


# 会员购物

## 点击商品信息

### 显示商品

### 购物车

### 立即购买

### 商品加入购物车

- 购物车

	- 显示图片，价格，商品名称
	- 数量添加，删除
	- 结算

		- 生成订单

			- 确认订单

				- 显示收货地址
				- 订单信息，订单数量
				- 运费，优惠券，礼品卡，积分，发票，订单金额等信息
				- 提交订单

					- 支付页面

						- 显示订单号
						- 显示总金额

	- 添加，移除商品

### 联系客服

### 收藏夹

- 添加商品收藏
- 移除商品收藏

## 我的订单

### 待付款

- 商品显示
- 取消订单
- 支付订单

### 待发货

### 待收货

### 已完成

### 查询订单




