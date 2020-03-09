package member.domain.member.sale;

import goods.domain.goods.Goods;
import member.domain.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class MemberSaleItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_sale_item_id")
    private Long id;

    //多对一关系映射
    @ManyToOne(targetEntity = MemberSale.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_sale_id", referencedColumnName = "member_sale_id")
    private MemberSale memberSale;
    /**
     * 商品信息
     */
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Goods.class)
    private Goods goods;

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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
