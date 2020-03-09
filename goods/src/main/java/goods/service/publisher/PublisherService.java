package goods.service.publisher;

import goods.domain.publisher.Publisher;

public interface PublisherService {

    Publisher save(Publisher publisher);

    Publisher findByName(String name);
}
