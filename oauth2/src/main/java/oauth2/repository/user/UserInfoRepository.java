package oauth2.repository.user;


import oauth2.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
}
