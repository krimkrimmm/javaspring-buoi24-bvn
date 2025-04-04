package vn.scrip.buoi24.service;

import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.model.enums.MovieType;
import vn.scrip.buoi24.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> findHotMovies(Boolean status, Integer limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by("rating").descending());
        return movieRepository.findByStatusOrderByRatingDesc(status, pageable);
    }

    public Page<Movie> findByType(MovieType type, Boolean status, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("publishedAt").descending());
        return movieRepository.findByTypeAndStatus(type, status, pageable);
    }

    public Movie findMovieDetails(Integer id, String slug) {
        return movieRepository.findByIdAndSlugAndStatus(id, slug, true);
    }
}
