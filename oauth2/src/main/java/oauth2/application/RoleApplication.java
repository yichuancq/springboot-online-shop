package oauth2.application;

import oauth2.domain.SysRole;
import oauth2.service.role.SysRoleService;
import oauth2.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
     * @param id
     */
    public void deleteRoleById(Long id) {
        assert (id != null);
        sysRoleService.deleteRoleById(id);
    }

    /**
     * @param sysRole
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public ResultDTO findByPage(SysRole sysRole, int pageNumber, int pageSize) {

        Page<SysRole> sysRolePage = sysRoleService.findAllByPage(sysRole, pageNumber, pageSize);
        return new ResultDTO(0, "ok", Math.toIntExact(sysRolePage.getTotalElements()),
                sysRolePage.getContent());
    }

    /**
     * @param sysRoleInput
     */
    public void roleMod(SysRole sysRoleInput) {
        if (sysRoleInput == null || sysRoleInput.getId() == null) {
            //用户为空或者ID为空
            return;
        }
        SysRole sysRoleInfoDb = sysRoleService.findRoleById(sysRoleInput.getId());
        if (sysRoleInfoDb != null) {
            sysRoleInfoDb.setRole(sysRoleInput.getRole());
            sysRoleInfoDb.setDescription(sysRoleInput.getDescription());
            sysRoleService.saveRole(sysRoleInfoDb);
        }

    }
}
