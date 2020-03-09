package goods.service.supplier;

import goods.domain.supplier.Supplier;
import goods.repository.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier save(Supplier supplier) {
        assert (supplier != null);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier findByName(String name) {
        assert (!name.isEmpty());
        return supplierRepository.findBySupplierName(name);
    }
}
