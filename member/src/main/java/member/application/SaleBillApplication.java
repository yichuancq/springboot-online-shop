package member.application;

import member.domain.bill.SaleBill;
import member.service.bill.SaleBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleBillApplication {

    @Autowired
    private SaleBillService saleBillService;

    /**
     * @param saleBill
     * @return
     * @throws Exception
     */
    public SaleBill findSaleBill(SaleBill saleBill) throws Exception {
        if (saleBill == null) {
            throw new Exception("会员信息为空");
        } else {
            return saleBillService.findBill(saleBill);
        }

    }

}
