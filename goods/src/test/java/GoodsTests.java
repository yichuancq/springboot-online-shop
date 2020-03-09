import goods.GoodsApplication;
import goods.domain.goods.Goods;
import goods.domain.publisher.Publisher;
import goods.domain.supplier.Supplier;
import goods.service.goods.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GoodsApplication.class)
public class GoodsTests {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void saveGoods() {

        List<Supplier> supplierList = new ArrayList<>();
        List<Publisher> publisherList = new ArrayList<>();

        Supplier supplier = new Supplier();
        supplier.setSupplierName("中信出版社");
        supplier.setAddress("北京朝阳路路18号");
        supplierList.add(supplier);
        ///
        Publisher publisher = new Publisher();
        publisher.setPublisherName("文艺出版社");
        publisher.setAddress("北京朝阳路路10号");
        publisherList.add(publisher);
        ///
        Goods goods = new Goods();
        goods.setName("理想国");
        ///价格
        goods.setSalePrice((BigDecimal.valueOf(40.5)));
        goods.setMemo("我是图书");
        goods.setPublisherList(publisherList);//出版社
        goods.setSupplierList(supplierList);//供应商
        goodsService.saveGoods(goods);

    }

    @Test
    public void findByName() {
        Goods goods = goodsService.findByName("理想国");
        assert (goods != null);
        System.out.println("" + goods.toString());
    }
}
