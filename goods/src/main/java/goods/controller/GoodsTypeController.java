package goods.controller;

import goods.application.GoodsTypeApplication;
import goods.domain.goods.GoodsType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Api(value = "商品类型信息API")
@RequestMapping("/goodsType")
public class GoodsTypeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GoodsTypeApplication goodsTypeApplication;

    @ApiOperation(value = "findByTypeName", notes = "findByTypeName")
    @RequestMapping(value = "/findByTypeName", method = RequestMethod.GET)
    private List<GoodsType> findByTypeName(String typeName) {
        return goodsTypeApplication.findByName(typeName);
    }


}
