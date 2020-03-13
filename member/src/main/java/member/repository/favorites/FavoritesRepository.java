package member.repository.favorites;

import member.domain.favorites.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 会员收藏夹
 */
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
