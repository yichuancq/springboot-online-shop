package goods.service.goods;

import goods.domain.goods.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    /**
     * save
     *
     * @return
     */
    GoodsType saveGoodsType(GoodsType goodsType);

    /**
     * @param goodsTypeName
     * @return
     */
    List<GoodsType> findTypeByName(String goodsTypeName);
}
