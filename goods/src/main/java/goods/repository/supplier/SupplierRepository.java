package goods.repository.supplier;

import goods.domain.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    //
    Supplier findBySupplierName(String name);
}
