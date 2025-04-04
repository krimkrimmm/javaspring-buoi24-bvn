package vn.scrip.buoi24.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.model.enums.MovieType;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Page<Movie> findByTypeAndStatus(MovieType type, boolean status, Pageable pageable);
    List<Movie> findByStatusOrderByRatingDesc(boolean status, Pageable pageable);
    Movie findByIdAndSlugAndStatus(Integer id, String slug, boolean status);
}
