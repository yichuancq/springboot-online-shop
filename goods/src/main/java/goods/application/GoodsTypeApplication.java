package goods.application;

import goods.domain.goods.GoodsType;
import goods.service.goods.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GoodsTypeApplication {

    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * @param typeName
     * @return
     */
    public List<GoodsType> findByName(String typeName) {
        assert (!StringUtils.isEmpty(typeName));
        return goodsTypeService.findTypeByName(typeName);
    }

    public GoodsType saveGoodsType(GoodsType goodsType) {
        assert (goodsType != null);
        return goodsTypeService.saveGoodsType(goodsType);
    }
}
