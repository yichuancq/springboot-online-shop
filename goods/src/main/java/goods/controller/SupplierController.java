package goods.controller;

import goods.application.SupplierApplication;
import goods.domain.supplier.Supplier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api(value = "供应商基本信息API")
@RequestMapping("/supplier")
public class SupplierController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SupplierApplication supplierApplication;

    @ApiOperation(value = "findByName", notes = "findByName")
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    Supplier findByName(String name) {
        return supplierApplication.findByName(name);
    }

}
