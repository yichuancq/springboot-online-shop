package member.repository.express;

import member.domain.express.MemberExpressInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员快递信息
 */
public interface MemberExpressInfoRepository extends JpaRepository<MemberExpressInfo, Long> {
}
