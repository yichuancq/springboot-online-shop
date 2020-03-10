package goods.service.goods;

import goods.domain.goods.Goods;
import goods.repository.goods.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品基本信息
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods saveGoods(Goods goods) {
        assert (goods != null);
        return goodsRepository.save(goods);
    }

    @Override
    public Goods findByName(String goodsName) {
        return goodsRepository.findByName(goodsName);
    }
}
