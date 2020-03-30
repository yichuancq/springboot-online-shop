package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.application.RoleApplication;
import oauth2.domain.SysPermission;
import oauth2.domain.SysRole;
import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Api(value = "roleController")
@Controller
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleApplication roleApplication;

    /**
     * @return
     */
    @ApiOperation(value = "addRole", notes = "addRole")
    @PostMapping("/addRole")
    private ModelAndView addRole(SysRole sysRole, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("sysRole:{}", sysRole);
        roleApplication.addSysRole(sysRole);
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userInfo);
        //sysRoleList
        request.setAttribute("sysRoleList", userInfo.getSysRoleList());
        List<SysPermission> sysPermissionList = new ArrayList<>();
        for (SysRole role : userInfo.getSysRoleList()) {
            sysPermissionList.addAll(role.getPermissions());
        }
        request.setAttribute("sysPermissionList", sysPermissionList);
        logger.info("userInfo:{}", userInfo.toString());
        request.setAttribute("username", userInfo.getUsername());
        modelAndView.setViewName("UserList");
        return modelAndView;
    }

    /**
     * @param roleId
     * @param request
     * @return
     */
    @GetMapping("/deleteRole")
    public String deleteRole(Long roleId, HttpServletRequest request) {
        logger.info("roleId:{}", roleId);
        roleApplication.deleteRoleById(roleId);
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userInfo);
        List<SysRole> sysRoleList = roleApplication.findAll();
        request.setAttribute("sysRoleList", sysRoleList);
        return "roleList";
    }

    /**
     * @param request
     * @return
     */
    @GetMapping("/roleList")
    public String toRoleListPage(HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setAttribute("userInfo", userInfo);
        List<SysRole> sysRoleList = roleApplication.findAll();
        request.setAttribute("sysRoleList", sysRoleList);
        return "roleList";
    }


}
