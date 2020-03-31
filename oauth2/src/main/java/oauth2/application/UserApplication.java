package oauth2.application;

import oauth2.domain.UserInfo;
import oauth2.service.user.UserInfoService;
import oauth2.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserApplication {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param userInfo
     */
    public void saveUser(UserInfo userInfo) {
        assert (userInfo != null);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!StringUtils.isEmpty(userInfo.getPassword())) {
            //加密用户信息
            userInfo.setPassword(encoder.encode(userInfo.getPassword().trim()));
        }
        userInfoService.saveUser(userInfo);
    }

    /**
     * @return
     */
    public List<UserInfo> findAll() {
        return userInfoService.findAll();
    }


    public void deleteUserById(Long userId) {
        assert (userId != null);
        userInfoService.deleteUserById(userId);
    }

    /**
     * @param userInfo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public ResultDTO findByPage(UserInfo userInfo, int pageNumber, int pageSize) {
        Page<UserInfo> userInfoPage = userInfoService.findAllByPage(userInfo, pageNumber, pageSize);
        return new ResultDTO(0, "ok", Math.toIntExact(userInfoPage.getTotalElements()),
                userInfoPage.getContent());
    }
}
