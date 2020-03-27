
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
public class PermissionTest {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;
    /**
     * 添加权限
     */
    @Test
    public void addUserPermission() {
        //
        SysPermission sysPermission = new SysPermission();
        //是否存在
        sysPermission.setAvailable(true);
        //权限管理名称
        sysPermission.setName("用户信息查看");
        //menu
        sysPermission.setResourceType("menu");
        //权限
        sysPermission.setPermission("goods:view");
        //设置资源路径
        sysPermission.setUrl("user/goodsList");
        //
        sysPermission.setParent(null);
        sysPermissionService.saveSysPermission(sysPermission);
    }

    //
    @Test
    public void addSubPermissions() {

        SysPermission sysPermission = sysPermissionService.findById(4L);
        List<SysPermission> sysPermissionList = new ArrayList<>();

        SysPermission sysPermission1 = new SysPermission();
        //是否存在
        sysPermission1.setAvailable(true);
        //权限管理名称
        sysPermission1.setName("用户信息修改");
        //menu
        sysPermission1.setResourceType("menu");
        //权限
        sysPermission1.setPermission("goods:update");
        //设置资源路径
        sysPermission1.setUrl("user/update");
        //
        sysPermission1.setParent(sysPermission);
        ////

        SysPermission sysPermission2 = new SysPermission();
        //是否存在
        sysPermission2.setAvailable(true);
        //权限管理名称
        sysPermission2.setName("用户信息删除");
        //menu
        sysPermission2.setResourceType("menu");
        //权限
        sysPermission2.setPermission("goods:delete");
        //设置资源路径
        sysPermission2.setUrl("user/delete");
        //
        sysPermission1.setParent(sysPermission);
        sysPermission2.setParent(sysPermission);

        sysPermissionList.add(sysPermission1);
        sysPermissionList.add(sysPermission2);
        //sub
        sysPermission.setSysPermissionList(sysPermissionList);
        //
        sysPermissionService.saveSysPermission(sysPermission);

    }

    /**
     * 给角色添加权限
     * modRole
     */
    @Test
    public void modPermissionRole() {
        //
        SysRole sysRole = sysRoleService.findRoleById(2L);
        //
        System.out.println("" + sysRole.toString());
        SysPermission sysPermission = sysPermissionService.findById(4L);
        //
        List<SysRole> sysRoleList = new ArrayList<>();
        //
        sysRoleList.add(sysRole);
        sysPermission.setSysRoleList(sysRoleList);
        sysPermissionService.saveSysPermission(sysPermission);
    }

}
