package goods.service.publisher;

import goods.domain.publisher.Publisher;
import goods.repository.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher save(Publisher publisher) {
        assert (publisher != null);
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher findByName(String name) {
        assert (!name.isEmpty());
        return publisherRepository.findByPublisherName(name);
    }
}
