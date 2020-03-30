package oauth2.application;

import oauth2.domain.SysRole;
import oauth2.service.role.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleApplication {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * add role
     *
     * @param sysRole
     */
    public void addSysRole(SysRole sysRole) {
        assert (sysRole != null);
        if (sysRole != null) {
            sysRole.setPermissions(null);
            sysRole.setUserInfoList(null);
            sysRole.setAvailable(true);
        }
        sysRoleService.saveRole(sysRole);
    }

    /**
     * @return
     */
    public List<SysRole> findAll() {
        List<SysRole> sysRoleList = sysRoleService.findAll();
        for (SysRole sysRole : sysRoleList) {
            sysRole.setUserInfoList(null);
            sysRole.setPermissions(null);
        }
        return sysRoleList;
    }

    /**
     * @param id
     */
    public void deleteRoleById(Long id) {
        assert (id != null);
        sysRoleService.deleteRoleById(id);
    }
}
