package oauth2.application;

import oauth2.domain.SysPermission;
import oauth2.service.permission.SysPermissionService;
import oauth2.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PermissionApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SysPermissionService sysPermissionService;


    /**
     * @param sysPermission
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public ResultDTO findByPage(SysPermission sysPermission, int pageNumber, int pageSize) {

        Page<SysPermission> sysRolePage = sysPermissionService.findAllByPage(sysPermission, pageNumber, pageSize);
        return new ResultDTO(0, "ok", Math.toIntExact(sysRolePage.getTotalElements()),
                sysRolePage.getContent());
    }

    /**
     * @param sysPermission
     */
    public void saveSysPermission(SysPermission sysPermission) throws Exception {
        assert (sysPermission != null);
        if (sysPermission != null) {
            sysPermission.setSysRoleList(null);
            sysPermission.setSysPermissionList(null);
            sysPermission.setAvailable(true);
        }
        if (StringUtils.isEmpty(sysPermission.getName())) {
            logger.info("权限名称为空");
            throw new Exception("权限名称为空");
        }
        if (StringUtils.isEmpty(sysPermission.getPermission())) {
            logger.info("权限为空");
            throw new Exception("权限为空");
        }
        sysPermissionService.saveSysPermission(sysPermission);
    }

    public void deleteUserById(Long permissionId) {
        assert (permissionId != null);
        sysPermissionService.deletePermissionById(permissionId);
    }
}
