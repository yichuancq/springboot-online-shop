package oauth2.service.permission;


import oauth2.domain.SysPermission;

/**
 * 权限
 */
public interface SysPermissionService {
    /**
     * 保存权限
     *
     * @param sysPermission
     */
    void saveSysPermission(SysPermission sysPermission);

    /**
     * @param id
     * @return
     */
    SysPermission findById(Long id);
}
