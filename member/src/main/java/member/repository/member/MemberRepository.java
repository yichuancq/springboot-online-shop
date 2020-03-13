package member.repository.member;

import member.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员信息
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
