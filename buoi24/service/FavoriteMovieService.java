package vn.scrip.buoi24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.repository.FavoriteMovieRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteMovieService {
    private final FavoriteMovieRepository favoriteMovieRepository;

    public List<Movie> getUserFavorites() {
        return favoriteMovieRepository.findByUserId(1); // Giả sử userId = 1 cố định
    }
}
