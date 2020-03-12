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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Long getNeedPoints() {
        return needPoints;
    }

    public void setNeedPoints(Long needPoints) {
        this.needPoints = needPoints;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
