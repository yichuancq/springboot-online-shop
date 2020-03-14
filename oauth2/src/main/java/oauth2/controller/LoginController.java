package oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    /**
     * @param error
     * @param logout
     * @return
     */
    @GetMapping("/")
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
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

    /**
     * @param error
     * @param logout
     * @return
     */
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

}
