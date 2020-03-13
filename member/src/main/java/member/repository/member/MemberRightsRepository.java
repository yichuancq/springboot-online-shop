package member.repository.member;

import member.domain.member.rights.MemberRights;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员权益
 */
public interface MemberRightsRepository extends JpaRepository<MemberRights, Long> {
}
