package oauth2.service.user;


import oauth2.domain.UserInfo;

/**
 * 用户信息
 */
public interface UserInfoService {
    /**
     * findUserByName
     * @param username
     * @return
     */
    UserInfo findUserByName(String username);

    /**
     * save
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

}
