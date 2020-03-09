package member.domain.member.gift;

import member.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 会员积分兑换礼品
 */
@Entity
public class MemberGift extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_gift_id")
    private Long id;

    /**
     * 礼品名称
     */
    private String giftName;

    /**
     * 需要的点数
     */
    private Long needPoints;

    /**
     * 礼品库存数量
     */
    private Integer amount;
}
