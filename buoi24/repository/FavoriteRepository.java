package vn.scrip.buoi24.repository;

import vn.scrip.buoi24.entity.Favorite;
import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);

    Optional<Favorite> findByUserAndMovie(User user, Movie movie);

    void deleteByUserAndMovie(User user, Movie movie);

    void deleteByUser(User user);

    boolean existsByUserAndMovie(User user, Movie movie);
}
