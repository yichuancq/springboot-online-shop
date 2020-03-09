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
    private String supplierId;
    //供应商名称
    private String supplierName;
    //地址
    private String address;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
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
