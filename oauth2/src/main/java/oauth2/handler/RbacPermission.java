package oauth2.handler;

import oauth2.domain.SysPermission;
import oauth2.domain.SysRole;
import oauth2.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * RBAC数据模型控制权限
 */
@Component("rbacPermission")
public class RbacPermission {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 是否有权限
     *
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        Boolean hasPermission = false;
        if (principal instanceof UserInfo) {
            //读取用户所拥有的权限菜单
            List<SysRole> roles = (List<SysRole>) ((UserInfo) principal).getSysRoleList();
            if (roles != null) {
                for (SysRole sysRole : roles) {
                    System.out.println("role name=>" + sysRole.getRole());
                    for (SysPermission permission : sysRole.getPermissions()) {
                        System.out.println("permission name=>" + permission.getName());
                        if (antPathMatcher.match(permission.getUrl(), request.getRequestURI())) {
                            hasPermission = true;
                            break;
                        }
                    }
                }
            }
        }
        return hasPermission;
    }
}
