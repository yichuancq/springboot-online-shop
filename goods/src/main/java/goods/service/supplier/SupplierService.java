package goods.service.supplier;

import goods.domain.supplier.Supplier;

/**
 * 供应商
 */
public interface SupplierService {

    /**
     * save
     *
     * @param supplier
     * @return
     */
    Supplier save(Supplier supplier);

    /**
     * findByName
     *
     * @param name
     * @return
     */
    Supplier findByName(String name);


}
