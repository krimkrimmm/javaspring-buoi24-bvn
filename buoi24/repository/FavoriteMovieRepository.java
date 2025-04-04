package vn.scrip.buoi24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.scrip.buoi24.entity.FavoriteMovie;
import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.entity.User;

import java.util.List;
import java.util.Optional;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Long> {
    List<FavoriteMovie> findByUser(User user);
    Optional<FavoriteMovie> findByUserAndMovie(User user, Movie movie);
    void deleteByUser(User user);

    List<Movie> findByUserId(int i);
}




