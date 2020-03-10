package goods.controller;

import goods.application.GoodsApplication;
import goods.domain.goods.Goods;
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
@Api(value = "商品信息API")
@RequestMapping("/goods")
public class GoodsController {
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    //
    @Autowired
    private GoodsApplication goodsApplication;

    /**
     * save goods
     *
     * @param goods
     */
    @ApiOperation(value = "saveGoods", notes = "saveGoods")
    @RequestMapping(value = "/saveGoods", method = RequestMethod.GET)
    public void saveGoods(Goods goods) {
        try {
            goodsApplication.saveGoods(goods);
        } catch (Exception e) {
            logger.error("ex:{}", e.getMessage());
            e.printStackTrace();
        }
    }

}
