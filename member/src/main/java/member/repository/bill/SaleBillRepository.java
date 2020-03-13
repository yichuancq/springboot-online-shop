package member.repository.bill;

import member.domain.bill.SaleBill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 销售单据
 */
public interface SaleBillRepository extends JpaRepository<SaleBill, Long> {
}
