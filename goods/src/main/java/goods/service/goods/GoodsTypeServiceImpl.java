package goods.service.goods;

import goods.domain.goods.GoodsType;
import goods.repository.goods.GoodsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @Override
    public GoodsType saveGoodsType(GoodsType goodsType) {
        return goodsTypeRepository.save(goodsType);
    }

    /**
     * @param goodsTypeName
     * @return
     */
    @Override
    public List<GoodsType> findTypeByName(String goodsTypeName) {
        return goodsTypeRepository.findByTypeName(goodsTypeName);
    }
}
