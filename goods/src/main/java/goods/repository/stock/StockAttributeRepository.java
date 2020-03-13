package goods.repository.stock;

import goods.domain.stock.StockAttribute;
import goods.domain.stock.StockAttributeCfg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 库存属性
 */
public interface StockAttributeRepository extends JpaRepository<StockAttribute, Long> {

    /**
     * @param stockAttributeCfg
     * @return
     */
    StockAttribute findStockAttributeByStockAttributeCfg(StockAttributeCfg stockAttributeCfg);

}
