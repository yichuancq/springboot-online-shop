package member.domain.cart;

import member.domain.base.BaseEntity;
import member.domain.bill.SaleBill;
import member.domain.member.Member;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车
 */
@Entity
public class ShoppingCart extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    /**
     * 会员信息
     */
    @ManyToOne
    private Member member;

    /**
     * 关联订单信息
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private SaleBill saleBill;


    @OneToMany(targetEntity = ShoppingCartItem.class, mappedBy = "shoppingCart", cascade = CascadeType.PERSIST)
    List<ShoppingCartItem> shoppingCartItemList;
    /**
     * 总码洋
     */
    private BigDecimal totalMoney = BigDecimal.ZERO;

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

    public SaleBill getSaleBill() {
        return saleBill;
    }

    public void setSaleBill(SaleBill saleBill) {
        this.saleBill = saleBill;
    }

    public List<ShoppingCartItem> getShoppingCartItemList() {
        return shoppingCartItemList;
    }

    public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
        this.shoppingCartItemList = shoppingCartItemList;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}
