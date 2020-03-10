package goods.domain.goods;

import goods.domain.base.BaseEntity;
import goods.domain.publisher.Publisher;
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
     * 商品名称
     */
    //@Column(unique = true)
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
    /**
     * 备注
     */
    private String memo;
    
    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsType=" + goodsType +
                ", supplierList=" + supplierList +
                ", publisherList=" + publisherList +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", salePrice=" + salePrice +
                ", imageUrl='" + imageUrl + '\'' +
                ", memo='" + memo + '\'' +
                '}';
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
