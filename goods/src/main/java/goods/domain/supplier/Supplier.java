package goods.domain.supplier;

import goods.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 供应商
 */
@Entity
public class Supplier extends BaseEntity {

    //供应商id
    @Id
    @GeneratedValue
    @Column(name = "supplier_id")
    private Long supplierId;

    //供应商名称
    //@Column(unique = true)
    private String supplierName;
    //地址
    private String address;

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
