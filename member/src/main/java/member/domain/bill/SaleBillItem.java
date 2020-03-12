package member.domain.bill;

import member.domain.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 销售订单明细
 */
@Entity
public class SaleBillItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "sale_bill_item_id")
    private Long id;

    //多对一关系映射
    @ManyToOne(targetEntity = SaleBill.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sale_bill_id", referencedColumnName = "sale_bill_id")
    private SaleBill saleBill;
    /**
     * 商品信息
     */
    //商品信息id
    private long goodsId;

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


    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public SaleBill getSaleBill() {
        return saleBill;
    }

    public void setSaleBill(SaleBill saleBill) {
        this.saleBill = saleBill;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
