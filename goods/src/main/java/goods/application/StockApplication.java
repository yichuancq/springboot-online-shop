package goods.application;

import goods.domain.stock.GoodsStock;
import goods.domain.stock.StockAttribute;
import goods.service.stock.GoodsStockService;
import goods.service.stock.StockAttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 库存application
 */
@Service
public class StockApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodsStockService goodsStockService;

    @Autowired
    private StockAttributeService stockAttributeService;

    /**
     * @param goodsStock
     * @return
     */
    public GoodsStock saveGoodsStock(GoodsStock goodsStock) {

        logger.info(goodsStock.toString());
        return goodsStockService.saveGoodsStock(goodsStock);
    }

    /**
     * @param stockAttribute
     * @return
     */
    public StockAttribute saveStockAttribute(StockAttribute stockAttribute) {
        logger.info(stockAttribute.toString());
        return stockAttributeService.saveStockAttribute(stockAttribute);
    }


}
