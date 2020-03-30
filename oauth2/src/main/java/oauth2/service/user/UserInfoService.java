package oauth2.service.user;


import oauth2.domain.UserInfo;

import java.util.List;

/**
 * 用户信息
 */
public interface UserInfoService {
    /**
     * findUserByName
     *
     * @param username
     * @return
     */
    UserInfo findUserByName(String username);

    /**
     * save
     *
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    List<UserInfo> findAll();

    /**
     *
     * @param id
     */
    void deleteUserById(Long id);

}
