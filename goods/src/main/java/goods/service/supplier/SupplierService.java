package goods.service.supplier;

import goods.domain.supplier.Supplier;

/**
 * 供应商
 */
public interface SupplierService {

    Supplier save(Supplier supplier);

    Supplier findByName(String name);


}
