package goods.repository.publisher;

import goods.domain.publisher.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByPublisherName(String name);
}
