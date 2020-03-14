package oauth2.service.role;

import oauth2.domain.SysRole;
import oauth2.repository.role.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    /**
     * @param sysRole
     */
    @Override
    public void saveRole(SysRole sysRole) {
        assert (sysRole != null);
        sysRoleRepository.save(sysRole);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SysRole findRoleById(Long id) {
       SysRole sysRole = null;
        Optional<SysRole> role = sysRoleRepository.findById(id);
        if (role.isPresent()) {
            sysRole = role.get();
        }
        return sysRole;
    }
}
