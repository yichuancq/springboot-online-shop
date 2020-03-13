package member.repository.member;

import member.domain.member.degree.MemberDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDegreeRepository extends JpaRepository<MemberDegree, Long> {
}
