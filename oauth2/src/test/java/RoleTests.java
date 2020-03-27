
import oauth2.Oauth2App;
import oauth2.domain.SysPermission;
import oauth2.domain.SysRole;
import oauth2.service.permission.SysPermissionService;
import oauth2.service.role.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Oauth2App.class)
public class RoleTests {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 只添加角色表
     */
    @Test
    public void addRole() {
        SysRole sysRole = new SysRole();
        sysRole.setAvailable(true);
        sysRole.setDescription("游客角色");
        sysRole.setPermissions(null);
        sysRole.setRole("ROLE_USER");
        sysRoleService.saveRole(sysRole);
        System.out.println("" + sysRole.toString());

        SysRole sysRole2 = new SysRole();
        sysRole2.setAvailable(true);
        sysRole2.setDescription("管理员角色");
        sysRole2.setPermissions(null);
        sysRole2.setRole("ROLE_ADMIN");
        sysRoleService.saveRole(sysRole2);
        System.out.println("" + sysRole2.toString());

    }


    /**
     *
     */
    @Test
    public void addPermission() {
        List<SysPermission> permissions = new ArrayList<>();
        SysPermission sysPermission = sysPermissionService.findById((long) 7);
        permissions.add(sysPermission);
        //
        SysRole sysRole = sysRoleService.findRoleById((long) 2);
        if (sysRole != null) {
            //permission
            sysRole.setPermissions(permissions);
            //save
            sysRoleService.saveRole(sysRole);
        }
    }


}
