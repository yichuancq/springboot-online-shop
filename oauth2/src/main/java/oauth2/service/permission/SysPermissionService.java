package oauth2.service.permission;


import oauth2.domain.SysPermission;

import java.util.List;

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
     * @param sysPermissions
     */
    void saveSysPermissions(List<SysPermission> sysPermissions);

    /**
     * @param id
     * @return
     */
    SysPermission findById(Long id);

    /**
     *
     * @param permission
     * @return
     */
    SysPermission findSysPermissionByPermission(String permission);
    /**
     * @param ids
     * @return
     */
    List<SysPermission> findByIds(List<Long> ids);
}
