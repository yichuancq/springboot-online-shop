package oauth2.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(value = "HomePage API")
@RequestMapping("/home")
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启授权
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView mav = new ModelAndView();
        if (error != null) {
            mav.addObject("error", "用户名或者密码不正确");
        }
        if (logout != null) {
            mav.addObject("msg", "退出成功");
        }
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("/getUser")
    public String getUsers() {
        return "Hello Spring Security";
    }

    @GetMapping("/welcome")
    public ModelAndView toMainPage() {
        //获取登录的用户名
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        mav.addObject("username", username);
        return mav;
    }
}
