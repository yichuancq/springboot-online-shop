package oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oauth2.application.PermissionApplication;
import oauth2.domain.SysPermission;
import oauth2.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "permissionController")
@Controller
public class PermissionController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PermissionApplication permissionApplication;

    /**
     * @param sysPermission
     * @return
     */
    @ApiOperation(value = "permissionAdd", notes = "permissionAdd")
    @PostMapping("/permissionAdd")
    @ResponseBody
    public ResponseEntity permissionAdd(SysPermission sysPermission) {
        try {
            assert (sysPermission != null);
            assert (!StringUtils.isEmpty(sysPermission.getPermission()));
            assert (!StringUtils.isEmpty(sysPermission.getUrl()));
            assert (!StringUtils.isEmpty(sysPermission.getName()));
            permissionApplication.saveSysPermission(sysPermission);
            ModelAndView mav = new ModelAndView();
            logger.info("sysPermission:{}", sysPermission);
            logger.info("添加权限");
            mav.addObject("msg", "OK");
            return ResponseEntity.ok(mav);
        } catch (Exception e) {
            logger.error("error:{}", e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/permissionData")
    @ResponseBody
    public ResponseEntity roleData(SysPermission sysPermission, int page, int limit)
            throws Exception {
        logger.info("page{},limit{}", page, limit);
        logger.info("roleData");
        ResultDTO resultDTO = permissionApplication.findByPage(sysPermission, page, limit);
        return ResponseEntity.ok(resultDTO);
    }


    @GetMapping("/permissionList")
    public String permissionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("permissionList");
        return "permissionList";
    }

    /**
     * 提示无权限
     *
     * @return
     */
    @ApiOperation(value = "permissionDelete", notes = "permissionDelete")
    @PostMapping("/permissionDelete")
    @ResponseBody
    public void permissionDelete(Long permissionId) {
        permissionApplication.deleteUserById(permissionId);
        logger.info("用户删除");
    }


}
