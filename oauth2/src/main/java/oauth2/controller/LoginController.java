package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.domain.UserInfo;
import oauth2.service.user.UserInfoService;
import oauth2.vo.ResponseData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Api(value = "loginController")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserInfoService userInfoService;
    /**
     * @return
     */
    @ApiOperation(value = "login", notes = "login")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity login(UserInfo userInfo, HttpServletRequest request) {
        logger.info("登录=>login");
        logger.info("userInfo:{}", userInfo);
        HttpSession httpSession = request.getSession();
        logger.info("sessionId:{}", httpSession.getId());
        return new ResponseData("登录成功", HttpStatus.valueOf(200));
    }

    /**
     * @return
     */
    @ApiOperation(value = "logout", notes = "logout")
    @GetMapping("/logout")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        logger.error("登录退出=>loginOut");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("msg", "logout");
        return "logout";
    }

    @ApiOperation(value = "loginOutSuccess", notes = "loginOutSuccess")
    @GetMapping("/loginOutSuccess")
    public String loginOutSuccess(HttpServletRequest request, HttpServletResponse response) {
        logger.error("登录退出成功=>loginOutSuccess");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.info("用户user:{}", auth.getName());
        request.setAttribute("msg", auth.getName() + ",登录退出成功");
        return "logoutOutSuccess";
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
