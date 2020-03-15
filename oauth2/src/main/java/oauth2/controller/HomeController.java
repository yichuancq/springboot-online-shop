package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(value = "HomeController")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

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
    @ApiOperation(value = "userList", notes = "userList")
    @GetMapping("/userList")
    public String showUsers() {
        return "userList";
    }

}
