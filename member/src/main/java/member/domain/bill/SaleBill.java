package member.domain.bill;

import member.domain.base.BaseEntity;
import member.domain.cart.ShoppingCart;
import member.domain.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 销售订单
 */
@Entity
public class SaleBill extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "sale_bill_id")
    private Long id;
    /**
     * 会员信息
     */
    @ManyToOne
    private Member member;

    /**
     * 关联购物车信息
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private ShoppingCart shoppingCart;

    /**
     * 消费明细
     */
    @OneToMany(targetEntity = SaleBillItem.class, mappedBy = "saleBill", cascade = CascadeType.PERSIST)
    private List<SaleBillItem> saleBillItemList;

    /**
     * 单据状态
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private SaleBillTypeCfg saleBillTypeCfg;
    /**
     * 操作人
     */
    private String operator;
    /**
     *
     */
    private LocalDateTime happenTime;
    /**
     * 消费地点
     *
     * @return
     */
    private String salePlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<SaleBillItem> getSaleBillItemList() {
        return saleBillItemList;
    }

    public void setSaleBillItemList(List<SaleBillItem> saleBillItemList) {
        this.saleBillItemList = saleBillItemList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDateTime getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(LocalDateTime happenTime) {
        this.happenTime = happenTime;
    }

    public String getSalePlace() {
        return salePlace;
    }

    public void setSalePlace(String salePlace) {
        this.salePlace = salePlace;
    }

    public SaleBillTypeCfg getSaleBillTypeCfg() {
        return saleBillTypeCfg;
    }

    public void setSaleBillTypeCfg(SaleBillTypeCfg saleBillTypeCfg) {
        this.saleBillTypeCfg = saleBillTypeCfg;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
