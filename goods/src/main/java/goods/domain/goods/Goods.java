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
     * 供应商
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Supplier> supplierList;
    /**
     * 出版社
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Publisher> publisherList;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 价格
     */
    private BigDecimal salePrice = BigDecimal.ZERO;
    /**
     * 备注
     */
    private String memo;

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
