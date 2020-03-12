package member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import member.application.SaleBillApplication;
import member.domain.bill.SaleBill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "销售订单API")
@RequestMapping("/bill")
public class SaleBillController {
    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private SaleBillApplication saleBillApplication;

    /**
     * @param saleBill
     * @return
     */
    @ApiOperation(value = "findSaleBill", notes = "findSaleBill")
    @RequestMapping(value = "/findSaleBill", method = RequestMethod.GET)
    public SaleBill findMember(SaleBill saleBill) {
        try {
            return saleBillApplication.findSaleBill(saleBill);
        } catch (Exception e) {
            logger.error("ex:{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
