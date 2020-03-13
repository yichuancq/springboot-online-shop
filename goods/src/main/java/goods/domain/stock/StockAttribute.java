package goods.domain.stock;

import goods.domain.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 库存属性
 */
@Entity
public class StockAttribute extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "stock_id")
    private Long id;
    /**
     * 库存类型
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private StockAttributeCfg stockAttributeCfg;
    /**
     * 状态
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StockAttributeCfg getStockAttributeCfg() {
        return stockAttributeCfg;
    }

    public void setStockAttributeCfg(StockAttributeCfg stockAttributeCfg) {
        this.stockAttributeCfg = stockAttributeCfg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
