package oauth2.service.role;


import oauth2.domain.SysRole;

/**
 * 角色
 */
public interface SysRoleService {
    /**
     * 保存角色
     *
     * @param sysRole
     */
    void saveRole(SysRole sysRole);

    /**
     * @param id
     * @return
     */
    SysRole findRoleById(Long id);

}
