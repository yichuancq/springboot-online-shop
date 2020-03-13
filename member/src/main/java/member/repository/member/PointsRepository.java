package member.repository.member;

import member.domain.member.points.Points;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员积分
 */
public interface PointsRepository extends JpaRepository<Points, Long> {
}
