package goods.domain.goods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goods.domain.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 商品类别
 */
@Entity
public class GoodsType extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "goods_type_id", unique = true)
    private Long id;
    //父编码
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_Id")
    @JsonIgnore
    private GoodsType parent;
    //类型名称
    private String typeName;
    //排序号
    private Integer typeOrder;
    //状态
    private Integer status;
    //
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    private List<GoodsType> goodsTypeList;
    //
    public GoodsType getParent() {
        return parent;
    }

    public void setParent(GoodsType parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", typeOrder=" + typeOrder +
                ", status=" + status +
                ", goodsTypeList=" + goodsTypeList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GoodsType> getGoodsTypeList() {
        return goodsTypeList;
    }

    public void setGoodsTypeList(List<GoodsType> goodsTypeList) {
        this.goodsTypeList = goodsTypeList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(Integer typeOrder) {
        this.typeOrder = typeOrder;
    }
}
