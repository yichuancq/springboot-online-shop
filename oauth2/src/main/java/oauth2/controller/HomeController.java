package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.domain.UserInfo;
import oauth2.service.user.UserInfoService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
@Api(value = "HomeController")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "login", notes = "login")
    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute UserInfo userInfo) {
        logger.info("user name:" + userInfo.getUsername());
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", userInfo.getNickname());
        mav.setViewName("login");
        return mav;
    }

    /**
     * @return
     */
    @ApiOperation(value = "logout", notes = "logout")
    @GetMapping("/logout")
    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) {
        logger.error("登录退出=>loginOut");
        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        mav.addObject("msg", "logout");
        mav.setViewName("logout");
        return mav;
    }

    @ApiOperation(value = "loginOutSuccess", notes = "loginOutSuccess")
    @GetMapping("/loginOutSuccess")
    public ModelAndView loginOutSuccess(HttpServletRequest request, HttpServletResponse response) {
        logger.error("登录退出成功=>loginOutSuccess");
        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.info("用户user:{}",auth.getName());
        mav.addObject("msg", auth.getName()+",登录退出成功");
        mav.setViewName("logoutOutSuccess");
        return mav;
    }

    /**
     * @return
     */
    @ApiOperation(value = "findUserByName", notes = "findUserByName")
    @GetMapping("/findUserByName")
    @PreAuthorize("hasRole('游客') or hasRole('管理员')")
    public ResponseEntity findUserByName(String userName) {
        UserInfo userInfo = userInfoService.findUserByName(userName);
        return ResponseEntity.ok(userInfo);
    }
}
