package oauth2.controller;

import io.swagger.annotations.Api;
import oauth2.domain.SysPermission;
import oauth2.domain.SysRole;
import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(value = "permissionController")
@Controller
public class PermissionController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 有权限验证
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/permissionList")
    public ModelAndView toPermissionListPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("userList");
        //获取登录的用户名
        ModelAndView mav = new ModelAndView();
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userInfo);
        //sysRoleList
        request.setAttribute("sysRoleList", userInfo.getSysRoleList());
        List<SysPermission> sysPermissionList = new ArrayList<>();
        for (SysRole sysRole : userInfo.getSysRoleList()) {
            sysPermissionList.addAll(sysRole.getPermissions());
        }
        request.setAttribute("sysPermissionList", sysPermissionList);
        logger.info("userInfo:{}", userInfo.toString());
        request.setAttribute("username", userInfo.getUsername());
        mav.setViewName("permissionList");
        return mav;
    }

}
