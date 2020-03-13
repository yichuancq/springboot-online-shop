package member.repository.member;

import member.domain.member.gift.MemberGift;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员礼品兑换
 */
public interface MemberGiftRepository extends JpaRepository<MemberGift, Long> {
}
