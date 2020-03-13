package member.repository.cart;

import member.domain.cart.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员购物车
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
