package goods.service.stock;

import goods.domain.goods.Goods;
import goods.domain.stock.GoodsStock;

public interface GoodsStockService {

    GoodsStock saveGoodsStock(GoodsStock goodsStock);

    GoodsStock findByGoods(Goods goods);
}
