package goods.service.stock;

import goods.domain.goods.Goods;
import goods.domain.stock.GoodsStock;
import goods.repository.stock.GoodsStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 库存
 */
@Service
public class GoodsStockServiceImpl implements GoodsStockService {

    @Autowired
    private GoodsStockRepository goodsStockRepository;

    @Override
    public GoodsStock saveGoodsStock(GoodsStock goodsStock) {
        assert (goodsStock != null);
        return goodsStockRepository.save(goodsStock);
    }

    @Override
    public GoodsStock findByGoods(Goods goods) {
        return goodsStockRepository.findByGoodsList(goods);
    }
}
