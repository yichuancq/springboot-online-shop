package goods.application;

import goods.domain.goods.Goods;
import goods.service.goods.GoodsService;
import goods.service.publisher.PublisherService;
import goods.service.supplier.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GoodsApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    //商品信息
    @Autowired
    private GoodsService goodsService;
    //供应商信息
    @Autowired
    private SupplierService supplierService;
    //出版社信息
    @Autowired
    private PublisherService publisherService;


    /**
     * @param goodsInput
     * @throws Exception
     */
    public void saveGoods(Goods goodsInput) throws Exception {
        if (goodsInput == null) {
            throw new Exception("添加的商品为空");
        }
        if (StringUtils.isEmpty(goodsInput.getName())) {
            throw new Exception("添加的商品名称为空");
        }
        //是否有相同名称的商品信息
        String goodsName = goodsInput.getName();
        //供应商
        //在数据库是否存在
        Goods goodsDB = goodsService.findByName(goodsName);
        if (goodsDB != null) {
            //是否存供应商信息
            if (goodsInput.getSupplierList() != null && goodsInput.getSupplierList().size() > 0) {
                //清空数据库的供应商信息
                goodsDB.getSupplierList().clear();
                //设置新的供应商信息
                goodsDB.setSupplierList(goodsInput.getSupplierList());
            }
            //是否存在出版社信息
            if (goodsInput.getPublisherList() != null && goodsInput.getPublisherList().size() > 0) {
                //清空出版社信息
                goodsDB.getPublisherList().clear();
                //设置新出版社信息
                goodsDB.setPublisherList(goodsInput.getPublisherList());
            }
            logger.info("save db goods-->{}", goodsDB.toString());
            //save
            goodsService.saveGoods(goodsDB);
        } else {
            logger.info("save goods-->{}", goodsInput.toString());
            //save db
            goodsService.saveGoods(goodsInput);
        }

    }

    /**
     * @param goodsName
     * @return
     */
    public Goods findByGoodsName(String goodsName) {
        if (StringUtils.isEmpty(goodsName)) {
            return null;
        }
        return goodsService.findByName(goodsName);
    }

}
