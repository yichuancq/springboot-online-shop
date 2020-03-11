package member.service.bill;

import member.domain.bill.SaleBill;
import member.repository.SaleBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleBillServiceImpl implements SaleBillService {
    @Autowired
    private SaleBillRepository saleBillRepository;


    @Override
    public SaleBill addBill(SaleBill saleBill) {
        return saleBillRepository.save(saleBill);
    }

    @Override
    public SaleBill findBill(SaleBill saleBill) {
        Example<SaleBill> example = Example.of(saleBill);
        Optional<SaleBill> optional = saleBillRepository.findOne(example);
        if (optional.isPresent()) {
            saleBill = optional.get();
            return saleBill;
        } else {
            return null;
        }
    }
}
