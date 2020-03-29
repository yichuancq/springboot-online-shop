package oauth2.handler;

import oauth2.domain.SysPermission;
import oauth2.domain.SysRole;
import oauth2.domain.UserInfo;
import oauth2.service.permission.SysPermissionService;
import oauth2.service.role.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义权限控制
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private SysRoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        Object principal = authentication.getPrincipal();
        UserInfo userInfo = (UserInfo) principal;
        List<SysRole> roles = userInfo.getSysRoleList();
        // 遍历用户所有角色
        for (SysRole sysRole : roles) {
            for (SysPermission sysPermission : sysRole.getPermissions()) {
                // 如果访问的Url和权限用户符合的话，返回true
                if (targetUrl.equals(sysPermission.getUrl()) &&
                        sysPermission.getPermission().equals(targetPermission)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
