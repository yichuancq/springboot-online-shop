package goods.service.publisher;

import goods.domain.publisher.Publisher;

/**
 * 出版社信息
 */
public interface PublisherService {

    /**
     * save
     *
     * @param publisher
     * @return
     */
    Publisher save(Publisher publisher);

    /**
     * findByName
     *
     * @param name
     * @return
     */
    Publisher findByName(String name);
}
