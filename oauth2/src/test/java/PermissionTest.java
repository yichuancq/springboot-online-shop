import oauth2.Oauth2App;
import oauth2.domain.SysPermission;
import oauth2.domain.SysRole;
import oauth2.service.permission.SysPermissionService;
import oauth2.service.role.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Oauth2App.class)
public class PermissionTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());


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
        sysPermission.setName("显示用户");
        //menu
        sysPermission.setResourceType("menu");
        //权限
        sysPermission.setPermission("sys:user:show");
        //设置资源路径
        sysPermission.setUrl("userList");
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
        sysPermission1.setName("添加用户");
        //menu
        sysPermission1.setResourceType("menu");
        //权限
        sysPermission1.setPermission("sys:user:add");
        //设置资源路径
        sysPermission1.setUrl("/userAdd");
        ////

        SysPermission sysPermission2 = new SysPermission();
        //是否存在
        sysPermission2.setAvailable(true);
        //权限管理名称
        sysPermission2.setName("删除用户");
        //menu
        sysPermission2.setResourceType("menu");
        //权限
        sysPermission2.setPermission("sys:user:delete");
        //设置资源路径
        sysPermission2.setUrl("/userDelete");
        //
        SysPermission sysPermission3 = new SysPermission();
        //是否存在
        sysPermission3.setAvailable(true);
        //权限管理名称
        sysPermission3.setName("修改用户");
        //menu
        sysPermission3.setResourceType("menu");
        //权限
        sysPermission3.setPermission("sys:user:update");
        //设置资源路径
        sysPermission3.setUrl("/userMod");
        //
        sysPermission1.setParent(sysPermission);
        sysPermission2.setParent(sysPermission);
        sysPermission3.setParent(sysPermission);

        sysPermissionList.add(sysPermission1);
        sysPermissionList.add(sysPermission2);
        sysPermissionList.add(sysPermission3);
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
        SysRole sysRole = sysRoleService.findRoleByRoleName("ROLE_ADMIN");
        System.out.println("" + sysRole.toString());
        SysPermission sysPermission = sysPermissionService.findSysPermissionByPermission("sys:user:show");
        //
        List<SysRole> sysRoleList = new ArrayList<>();
        sysRoleList.add(sysRole);
        //先请父类权限的角色
        sysPermission.getSysRoleList().clear();
        //添加权限子集
        List<SysPermission> subPermissions = sysPermission.getSysPermissionList();
        for (SysPermission subPermission : subPermissions) {
            System.out.println("");
            logger.info("permission =>{}", subPermission.getPermission());
            //子权限添加角色
            subPermission.setSysRoleList(sysRoleList);
        }
        //重新设置角色
        sysPermission.setSysRoleList(sysRoleList);
        sysPermissionService.saveSysPermission(sysPermission);
    }

}
