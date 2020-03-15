package oauth2.controller;

import io.swagger.annotations.Api;
import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(value = "HomePage API")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @param userInfo
     * @return
     */
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
    @GetMapping("/userList")
    public String showUsers() {
        return "userList";
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
        mav.addObject("username", username);
        mav.setViewName("welcome");
        return mav;
    }
}
