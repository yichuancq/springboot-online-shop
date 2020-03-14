package oauth2.service.permission;


import oauth2.domain.SysPermission;
import oauth2.repository.permission.SysPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    /**
     * @param sysPermission
     */
    @Override
    public void saveSysPermission(SysPermission sysPermission) {
        sysPermissionRepository.save(sysPermission);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SysPermission findById(Long id) {
        SysPermission sysPermission = null;
        Optional<SysPermission> permission = sysPermissionRepository.findById(id);
        if (permission.isPresent()) {
            sysPermission = permission.get();
        }
        return sysPermission;
    }
}
