package goods.repository.goods;

import goods.domain.goods.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long> {

    List<GoodsType> findByTypeName(String name);
}
