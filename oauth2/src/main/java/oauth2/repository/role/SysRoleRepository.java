package oauth2.repository.role;

import oauth2.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> , JpaSpecificationExecutor<SysRole> {

    SysRole findByRole(String role);
}
