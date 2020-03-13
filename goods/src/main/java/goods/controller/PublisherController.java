package goods.controller;

import goods.application.PublisherApplication;
import goods.domain.publisher.Publisher;
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
@Api(value = "出版社信息API")
@RequestMapping("/publisher")
public class PublisherController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PublisherApplication publisherApplication;

    /**
     * @param name
     * @return
     */
    @ApiOperation(value = "findByName", notes = "findByName")
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    private Publisher findByName(String name) {
        return publisherApplication.findByName(name);
    }


}
