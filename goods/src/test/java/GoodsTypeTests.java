import goods.GoodsApp;
import goods.application.GoodsTypeApplication;
import goods.domain.goods.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GoodsApp.class)
public class GoodsTypeTests {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GoodsTypeApplication goodsTypeApplication;

    @Test
    public void save() {
        //
        GoodsType goodsType = new GoodsType();
        goodsType.setId(1L);
        goodsType.setTypeName("root");
        goodsType.setStatus(1);
        goodsType.setTypeOrder(0);
        goodsType.setGoodsTypeList(null);
        goodsTypeApplication.saveGoodsType(goodsType);
    }

    /**
     * saveSubType
     */
    @Test
    public void saveSubType() {
        //https://blog.csdn.net/u012075238/article/details/91616164
        List<GoodsType> goodsTypes = goodsTypeApplication.findByName("文学");
        //
        GoodsType goodsType1 = new GoodsType();
        goodsType1.setId(4L);
        goodsType1.setTypeName("儿童文学");
        goodsType1.setStatus(1);
        goodsType1.setTypeOrder(0);
        goodsType1.setParent(goodsTypes.get(0));
        goodsTypeApplication.saveGoodsType(goodsType1);
        //
        GoodsType goodsType2 = new GoodsType();
        goodsType2.setId(5L);
        goodsType2.setTypeName("青年文学");
        goodsType2.setStatus(1);
        goodsType2.setTypeOrder(0);
        goodsType2.setParent(goodsTypes.get(0));
        goodsTypeApplication.saveGoodsType(goodsType2);
        //
    }

    @Test
    public void findByName() {
        //
        List<GoodsType> goodsTypes = goodsTypeApplication.findByName("root");
        for (GoodsType goodsType : goodsTypes) {
            logger.info("goods type:{}",goodsType.getTypeName());
            System.out.println("sub " + goodsType.getGoodsTypeList());
        }
    }
}
