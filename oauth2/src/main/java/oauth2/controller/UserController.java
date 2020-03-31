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
import java.util.List;
import java.util.Map;

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
        //userList
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
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String userDelete(Long userId, HttpServletRequest request) {
        userApplication.deleteUserById(userId);
        UserInfo userCash = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userCash);
        logger.info("用户删除");
        request.setAttribute("userInfoList", userApplication.findAll());
        return "userList";
    }

    /**
     * @return
     */
    @ApiOperation(value = "userMod", notes = "userMod")
    @GetMapping("/userMod")
    @PostAuthorize("hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')")
    public ModelAndView userMod(UserInfo userInfoInput, HttpServletRequest request, HttpServletResponse response) {
        logger.info("用户修改");
        ModelAndView mav = new ModelAndView();
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userInfo);
        logger.info("userInfo:{}", userInfo.toString());
        mav.setViewName("userList");
        //mav.setViewName("userMod");
        return mav;
    }

    @GetMapping("/userData")
    @ResponseBody
    public ResponseEntity userData(Map<String, Object> model, int page, int limit, String driverType)
            throws Exception {
        logger.info("userData");
        List<UserInfo> userInfoList = userApplication.findAll();
        //
        ResultDTO resultDTO = new ResultDTO<>(0, "ok", userInfoList.size(), userInfoList);
        return ResponseEntity.ok(resultDTO);
    }

    /**
     * 有权限验证
     *
     * @param request
     * @param response
     * @return
     */
//    @GetMapping("/userList")
//    @PostAuthorize("hasRole('ROLE_ADMIN')")
//    public ModelAndView userList(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        logger.info("userList");
//        //获取登录的用户名
//        ModelAndView mav = new ModelAndView();
//        //UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       // request.setAttribute("userInfo", userInfo);
//        request.setAttribute("userInfoList", userApplication.findAll());
//        mav.setViewName("userList");
//        return mav;
//    }
    @GetMapping("/userList")
//    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String userList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("userList");
        return "userList";
    }
}
