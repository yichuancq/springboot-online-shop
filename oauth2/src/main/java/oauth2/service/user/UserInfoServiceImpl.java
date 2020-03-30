package oauth2.service.user;

import oauth2.domain.UserInfo;
import oauth2.repository.user.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * user service
     */
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * findUserByName
     *
     * @param username
     * @return
     */
    @Override
    public UserInfo findUserByName(String username) {
        assert (!username.isEmpty());
        return userInfoRepository.findByUsername(username);
    }

    /**
     * save user
     *
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        assert (userInfo != null);
        userInfoRepository.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userInfoRepository.deleteById(id);
    }
}
