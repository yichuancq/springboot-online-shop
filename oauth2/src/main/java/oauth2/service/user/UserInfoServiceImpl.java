package oauth2.service.user;

import oauth2.domain.UserInfo;
import oauth2.repository.user.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public UserInfo findUserById(Long id) {
        Optional<UserInfo> userInfo = userInfoRepository.findById(id);
        if (userInfo.isPresent()) {
            return userInfo.get();
        }
        return null;
    }

    /**
     * @param userInfo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<UserInfo> findAllByPage(UserInfo userInfo, int pageNumber, int pageSize) {
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);
        Specification<UserInfo> specification = (Specification<UserInfo>) (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<Predicate>();
            //姓名
            if (userInfo != null && !StringUtils.isEmpty(userInfo.getUsername())) {
                Predicate predicate = cb.equal(root.get("username"), userInfo.getUsername());
                predicateList.add(predicate);
            }
            //昵称
            if (userInfo != null && !StringUtils.isEmpty(userInfo.getNickname())) {
                Predicate predicate = cb.equal(root.get("nickname"), userInfo.getNickname());
                predicateList.add(predicate);
            }
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
        Page<UserInfo> page = userInfoRepository.findAll(specification, pageable);
        return page;

    }
}
