package goods.application;

import goods.domain.publisher.Publisher;
import goods.service.publisher.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    //出版社信息
    @Autowired
    private PublisherService publisherService;

    /**
     * @param name
     * @return
     */
    public Publisher findByName(String name) {
        return publisherService.findByName(name);
    }

}
