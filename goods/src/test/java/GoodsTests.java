import goods.GoodsApp;
import goods.application.GoodsApplication;
import goods.domain.goods.Goods;
import goods.domain.publisher.Publisher;
import goods.domain.supplier.Supplier;
import goods.service.goods.GoodsService;
import goods.service.publisher.PublisherService;
import goods.service.supplier.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GoodsApp.class)
public class GoodsTests {

    @Autowired
    private GoodsApplication goodsApplication;
    //商品信息
    @Autowired
    private GoodsService goodsService;
    //供应商信息
    @Autowired
    private SupplierService supplierService;
    //出版社信息
    @Autowired
    private PublisherService publisherService;


    @Test
    public void saveGoods() throws Exception {
        //出版社信息
        List<Supplier> supplierList = new ArrayList<>();
        //供应商信息
        List<Publisher> publisherList = new ArrayList<>();
        //
        Supplier supplier = supplierService.findByName("中信出版社");
        if (supplier == null) {
            supplier = new Supplier();
            supplier.setSupplierName("中信出版社");
            supplier.setAddress("北京朝阳路路18号");
        }
        supplierList.add(supplier);
        //
        Publisher publisher = publisherService.findByName("文艺出版社");
        if (publisher == null) {
            publisher = new Publisher();
            publisher.setPublisherName("文艺出版社");
            publisher.setAddress("北京朝阳路路10号");
        }
        publisherList.add(publisher);
        Goods goods = new Goods();
        //价格
        goods.setSalePrice((BigDecimal.valueOf(40.5)));
        goods.setPublisherList(publisherList);//出版社
        goods.setSupplierList(supplierList);//供应商
        goods.setName("理想国");
        goods.setMemo("我是图书");
        goodsApplication.saveGoods(goods);

    }


//    @Test
//    public void saveGoods() {
//        //出版社信息
//        List<Supplier> supplierList = new ArrayList<>();
//        //供应商信息
//        List<Publisher> publisherList = new ArrayList<>();
//        //
//        Supplier supplier = new Supplier();
//        supplier.setSupplierName("中信出版社");
//        supplier.setAddress("北京朝阳路路18号");
//        supplierList.add(supplier);
//        //
//        Publisher publisher = new Publisher();
//        publisher.setPublisherName("文艺出版社");
//        publisher.setAddress("北京朝阳路路10号");
//        publisherList.add(publisher);
//        //
//        Goods goods = new Goods();
//        //价格
//        goods.setSalePrice((BigDecimal.valueOf(40.5)));
//        goods.setPublisherList(publisherList);//出版社
//        goods.setSupplierList(supplierList);//供应商
//        goods.setName("理想国");
//        goods.setMemo("我是图书");
//        goodsService.saveGoods(goods);
//
//    }

    /**
     * 中信出版社
     * patchSaveGoods
     */
    @Test
    public void patchSaveGoods() {
        List<Supplier> supplierList = new ArrayList<>();
        List<Publisher> publisherList = new ArrayList<>();
        //
        for (int i = 0; i < 50; i++) {
            supplierList.clear();
            publisherList.clear();
            Supplier supplier = supplierService.findByName("中信出版社");
            if (supplier == null) {
                supplier = new Supplier();
                supplier.setSupplierName("中信出版社");
                supplier.setAddress("北京朝阳路路18号");
            }
            supplierList.add(supplier);
            //
            Publisher publisher = publisherService.findByName("文艺出版社");
            if (publisher == null) {
                publisher = new Publisher();
                publisher.setPublisherName("文艺出版社");
                publisher.setAddress("北京朝阳路路10号");
            }
            publisherList.add(publisher);
            //
            Goods goods = new Goods();
            //价格
            goods.setSalePrice((BigDecimal.valueOf(40.5)));
            goods.setPublisherList(publisherList);//出版社
            goods.setSupplierList(supplierList);//供应商
            goods.setName("理想国" + i);
            goods.setMemo("我是图书");
            goodsService.saveGoods(goods);
        }
    }

    /**
     * findByName
     */
    @Test
    public void findByName() {
        //理想国
        Goods goods = goodsService.findByName("理想国0");
        assert (goods != null);
        System.out.println(goods.toString());
    }
}
