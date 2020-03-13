package goods.repository.stock;

import goods.domain.goods.Goods;
import goods.domain.stock.GoodsStock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 库存
 */
public interface GoodsStockRepository extends JpaRepository<GoodsStock, Long> {

    GoodsStock findByGoodsList(Goods goods);
}
