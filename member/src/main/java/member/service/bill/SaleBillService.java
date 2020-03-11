package member.service.bill;

import member.domain.bill.SaleBill;

/**
 * bill
 */
public interface SaleBillService {

    SaleBill addBill(SaleBill saleBill);

    SaleBill findBill(SaleBill saleBill);
}
