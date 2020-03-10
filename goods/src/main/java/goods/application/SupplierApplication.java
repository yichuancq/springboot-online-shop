package goods.application;

import goods.domain.supplier.Supplier;
import goods.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SupplierApplication {

    @Autowired
    private SupplierService supplierService;

    public Supplier findByName(String name) {
        assert (StringUtils.isEmpty(name));
        return supplierService.findByName(name);
    }
}
