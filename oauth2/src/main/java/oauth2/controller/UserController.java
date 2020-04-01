package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.application.UserApplication;
import oauth2.domain.UserInfo;
import oauth2.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "userController")
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserApplication userApplication;

    /**
     * @return
     */
    @ApiOperation(value = "userAdd", notes = "userAdd")
    @PostMapping("/userAdd")
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission('/userAdd','sys:user:add')")
    public ModelAndView userAdd(UserInfo userInfo, HttpServletRequest request) {
        logger.info("用户添加");
        ModelAndView mav = new ModelAndView();
        userApplication.saveUser(userInfo);
        UserInfo userCash = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userCash);
        request.setAttribute("userInfoList", userApplication.findAll());
        mav.setViewName("userList");
        return mav;
    }

    /**
     * 提示无权限
     *
     * @return
     */
    @ApiOperation(value = "userDelete", notes = "userDelete")
    @GetMapping("/userDelete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public void userDelete(Long userId) {
        userApplication.deleteUserById(userId);
        logger.info("用户删除");
    }

    /**
     * @return
     */
    @ApiOperation(value = "userMod", notes = "userMod")
    @PostMapping("/userMod")
    @PostAuthorize("hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')")
    public ResponseEntity userMod(UserInfo userInfoInput, HttpServletRequest request, HttpServletResponse response) {
        logger.info("用户修改");
        ModelAndView mav = new ModelAndView();
        logger.info("userData:{}", userInfoInput);
        mav.addObject("msg", "OK");
        userApplication.userMod(userInfoInput);
        return ResponseEntity.ok(mav);
    }

    @GetMapping("/userData")
    @ResponseBody
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity userData(UserInfo userInfo, int page, int limit)
            throws Exception {
        logger.info("page{},limit{}", page, limit);
        logger.info("userData");
        ResultDTO resultDTO = userApplication.findByPage(userInfo, page, limit);
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping("/userList")
    public String userList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("userList");
        return "userList";
    }

}
