package member.application;

import member.domain.bill.SaleBill;
import member.service.bill.SaleBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleBillApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());
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
