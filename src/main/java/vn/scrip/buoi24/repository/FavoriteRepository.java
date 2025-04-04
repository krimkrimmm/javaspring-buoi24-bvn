package vn.scrip.buoi24.repository;
import vn.scrip.buoi24.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}