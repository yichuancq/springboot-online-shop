package member.repository;

import member.domain.bill.SaleBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleBillRepository extends JpaRepository<SaleBill, Long> {
}
