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

}
