package goods.domain.goods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import goods.domain.base.BaseEntity;
import goods.domain.publisher.Publisher;
import goods.domain.stock.GoodsStock;
import goods.domain.supplier.Supplier;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品信息
 */
@Entity
public class Goods extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "goods_id")
    private Long id;
    /**
     * 商品类别
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    private GoodsType goodsType;
    /**
     * 供应商
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Supplier> supplierList;
    /**
     * 出版社
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Publisher> publisherList;
    /**
     * 商品库存信息
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<GoodsStock> goodsStockList;
    /**
     * 商品名称
     */
    private String name;

    /**
     * isbn
     */
    private String isbn;
    /**
     * 价格
     */
    private BigDecimal salePrice = BigDecimal.ZERO;

    /**
     * http://localhost:8081/images/lixiangguo2.jpeg
     * 图片路径
     */
    @Transient
    private String imageUrl;
    /***
     * 作者
     */
    private String author;
    /**
     * 译者
     */
    private String translator;
    /**
     * 备注
     */
    private String memo;

    public List<GoodsStock> getGoodsStockList() {
        return goodsStockList;
    }

    public void setGoodsStockList(List<GoodsStock> goodsStockList) {
        this.goodsStockList = goodsStockList;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }

}
