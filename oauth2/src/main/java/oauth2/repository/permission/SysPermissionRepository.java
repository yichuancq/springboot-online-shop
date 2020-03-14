package oauth2.repository.permission;

import oauth2.domain.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysPermissionRepository extends JpaRepository<SysPermission,Long> {
}
