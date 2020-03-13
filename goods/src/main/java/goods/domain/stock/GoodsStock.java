package goods.domain.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import goods.domain.base.BaseEntity;
import goods.domain.goods.Goods;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品库存
 */
@Entity
public class GoodsStock extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "stock_id")
    private Long stockId;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Goods> goodsList;
    /**
     * 入库库存属性
     */
    @OneToOne
    private StockAttribute inStockAttribute;

    /**
     * 出库库存属性
     */
    @OneToOne
    private StockAttribute outStockAttribute;

    /**
     * 入库名称
     */
    private String inStockAttributeName;

    /**
     * 出库名称
     */
    private String outStockAttributeName;
    /**
     * 价格
     */
    private BigDecimal salePrice = BigDecimal.ZERO;
    /**
     * 商品数量
     */
    private Integer amount;
    /**
     * 操作人
     */
    private String operator;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public StockAttribute getInStockAttribute() {
        return inStockAttribute;
    }

    public void setInStockAttribute(StockAttribute inStockAttribute) {
        this.inStockAttribute = inStockAttribute;
    }

    public StockAttribute getOutStockAttribute() {
        return outStockAttribute;
    }

    public void setOutStockAttribute(StockAttribute outStockAttribute) {
        this.outStockAttribute = outStockAttribute;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInStockAttributeName() {
        return inStockAttributeName;
    }

    public void setInStockAttributeName(String inStockAttributeName) {
        this.inStockAttributeName = inStockAttributeName;
    }

    public String getOutStockAttributeName() {
        return outStockAttributeName;
    }

    public void setOutStockAttributeName(String outStockAttributeName) {
        this.outStockAttributeName = outStockAttributeName;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
