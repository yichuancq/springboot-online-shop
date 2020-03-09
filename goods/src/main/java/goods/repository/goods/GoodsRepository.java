package goods.repository.goods;

import goods.domain.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

    Goods findByName(String goodsName);
}
