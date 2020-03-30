package oauth2.application;

import oauth2.domain.SysPermission;
import oauth2.service.permission.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionApplication {

    @Autowired
    private SysPermissionService sysPermissionService;

    public void saveSysPermission(SysPermission sysPermission) {
        sysPermissionService.saveSysPermission(sysPermission);
    }
}
