package goods.service.stock;

import goods.domain.stock.StockAttribute;
import goods.domain.stock.StockAttributeCfg;
import goods.repository.stock.StockAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存属性
 */
@Service
public class StockAttributeServiceImpl implements StockAttributeService {

    @Autowired
    private StockAttributeRepository stockAttributeRepository;

    @Override
    public List<StockAttribute> saveAllStockAttribute(List<StockAttribute> stockAttributes) {
        return stockAttributeRepository.saveAll(stockAttributes);
    }

    @Override
    public StockAttribute saveStockAttribute(StockAttribute stockAttribute) {
        return stockAttributeRepository.save(stockAttribute);
    }

    @Override
    public StockAttribute findStockAttributeByStockAttributeCfg(StockAttributeCfg stockAttributeCfg) {
        return stockAttributeRepository.findStockAttributeByStockAttributeCfg(stockAttributeCfg);
    }
}
