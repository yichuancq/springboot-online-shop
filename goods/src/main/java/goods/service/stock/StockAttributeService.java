package goods.service.stock;

import goods.domain.stock.StockAttribute;
import goods.domain.stock.StockAttributeCfg;

import java.util.List;

/**
 * 库存属性
 */
public interface StockAttributeService {

    /**
     * 批量保存
     *
     * @param stockAttributes
     * @return
     */
    List<StockAttribute> saveAllStockAttribute(List<StockAttribute> stockAttributes);

    /**
     * @param stockAttribute
     * @return
     */
    StockAttribute saveStockAttribute(StockAttribute stockAttribute);

    StockAttribute findStockAttributeByStockAttributeCfg(StockAttributeCfg stockAttributeCfg);
}
