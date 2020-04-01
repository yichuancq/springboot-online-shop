import oauth2.Oauth2App;
import oauth2.domain.SysRole;
import oauth2.domain.UserInfo;
import oauth2.repository.user.UserInfoRepository;
import oauth2.service.role.SysRoleService;
import oauth2.service.user.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Oauth2App.class)
public class UserTests {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;
    //role
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    UserInfoRepository userInfoRepository;

    /**
     * saveUser
     */
    @Test
    public void saveUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userInfo.setPassword("123456");
        userInfo.setPassword(encoder.encode(userInfo.getPassword().trim()));
        userInfo.setNickname("admin");
        Byte state = 1;
        userInfo.setState(state);
        String salt = UUID.randomUUID().toString();
        System.out.println(salt);
        userInfoService.saveUser(userInfo);


    }

    /**
     * findUserByName
     */
    @Test
    public void findUserByName() {
        UserInfo userInfo = userInfoService.findUserByName("admin");
        assert (userInfo != null);
        System.out.println("" + userInfo.toString());
        logger.info("name:{}", userInfo.getNickname());

    }

    /**
     * 修改用户状态
     */
    @Test
    public void updateUser() {
        UserInfo userInfo = userInfoService.findUserByName("admin");
        // 进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userInfo.setPassword("123456");
        //
        userInfo.setPassword(encoder.encode(userInfo.getPassword().trim()));
        assert (userInfo != null);
        Byte userState = 1;  //用户状态
        userInfo.setState(userState);
        userInfoService.saveUser(userInfo);
        System.out.println("" + userInfo.toString());
    }

    /**
     * 修改用户的角色
     */
    @Test
    public void updateUserRole() {
        UserInfo userInfo = userInfoService.findUserByName("admin");
        List<SysRole> sysRoleList = new ArrayList<>();
        //找到管理员角色
        SysRole sysRole = sysRoleService.findRoleByRoleName("ROLE_ADMIN");
        sysRoleList.add(sysRole);//add role
        assert (userInfo != null);
        Byte userState = 1;  //用户状态
        userInfo.setState(userState);
        userInfo.setSysRoleList(sysRoleList);
        userInfoService.saveUser(userInfo);
        System.out.println("" + userInfo.toString());
    }


    @Test
    public void findByPage() {
        UserInfo userInfo = userInfoService.findUserByName("admin");
        userInfoService.findAllByPage(userInfo, 0, 1);

    }

    @Test
    public void findAll() {
        int pageNo = 0;
        int size = 10;
        Pageable pageable = new PageRequest(pageNo, size);

        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("username");
                Predicate predicate = cb.equal(path, "admin");
                return predicate;
            }
        };
        Page<UserInfo> page = userInfoRepository.findAll(specification, pageable);
        List<UserInfo> studentList = page.getContent();
        for (UserInfo userInfo : studentList) {
            System.out.println(userInfo);
        }
        page.getTotalElements();
        page.getTotalPages();
    }
}