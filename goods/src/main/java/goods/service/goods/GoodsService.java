package goods.service.goods;

import goods.domain.goods.Goods;

/**
 * 商品基本信息
 */
public interface GoodsService {
    /**
     * save
     *
     * @return
     */
    Goods saveGoods(Goods goods);

    /**
     * @param goodsName
     * @return
     */
    Goods findByName(String goodsName);
}
