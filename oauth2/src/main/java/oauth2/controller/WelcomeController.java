package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(value = "WelcomeController")
public class WelcomeController {

    @ApiOperation(value = "welcome", notes = "welcome")
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
        mav.setViewName("main");
        mav.addObject("username", username);
        return mav;
    }


}
