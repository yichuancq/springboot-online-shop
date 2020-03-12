package member.domain.cart;

import member.domain.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 购物车明细
 */
@Entity
public class ShoppingCartItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    //多对一关系映射
    @ManyToOne(targetEntity = ShoppingCart.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private ShoppingCart shoppingCart;
    /**
     * 商品Id
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
    /**
     * 购物数量
     */
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
