package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.domain.UserInfo;
import oauth2.service.user.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


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
    public ModelAndView loginOut() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "logout");
        mav.setViewName("logout");
        return mav;
    }


    /**
     * @return
     */
    @ApiOperation(value = "findUserByName", notes = "findUserByName")
    @GetMapping("/findUserByName")
    public ResponseEntity findUserByName(String userName) {
        UserInfo userInfo = userInfoService.findUserByName(userName);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }
}
