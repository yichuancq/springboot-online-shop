package member.domain.favorites;

import member.domain.base.BaseEntity;
import member.domain.member.Member;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 会员收藏夹
 */
@Entity
public class Favorites extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "favorites_id")
    private Long id;

    /**
     * 会员信息
     */
    @ManyToOne
    private Member member;

    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
