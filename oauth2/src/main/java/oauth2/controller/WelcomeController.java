package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@Api(value = "WelcomeController")
public class WelcomeController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "welcome", notes = "welcome")
    @GetMapping("/welcome")
//    @PostAuthorize("hasRole('管理员') or hasRole('admin')")
    public ModelAndView welcome() {
        //获取登录的用户名
        ModelAndView mav = new ModelAndView();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = (UserInfo) principal;
        String username = null;
        if (principal instanceof UserDetails) {
            username = userInfo.getUsername();
        } else {
            username = principal.toString();
        }
        logger.info("user name:{}", username);
        mav.setViewName("welcome");
        mav.addObject("userInfo", userInfo);
        mav.addObject("username", username);
        return mav;
    }

    @GetMapping("/error")
    public String toErrorPage() {
        return "error";
    }

    /**
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/userList")
    //@PostAuthorize("hasRole('管理员') or hasRole('admin')")
    public String userList(HttpServletRequest request, HttpServletResponse response) {
        logger.info("toIndexPage");
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userInfo);
        //sysRoleList
        request.setAttribute("sysRoleList", userInfo.getSysRoleList());
        logger.info("userInfo:{}", userInfo.toString());
        return "userList";
    }


}
