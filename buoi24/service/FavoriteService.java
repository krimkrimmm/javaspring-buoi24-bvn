package vn.scrip.buoi24.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.scrip.buoi24.entity.Favorite;
import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.entity.User;

import vn.scrip.buoi24.repository.FavoriteRepository;
import vn.scrip.buoi24.repository.MovieRepository;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final MovieRepository movieRepository;

    // Lấy danh sách phim yêu thích của user
    public List<Favorite> getFavorites(User user) {
        return favoriteRepository.findByUser(user);
    }
    // Thêm phim vào danh sách yêu thích
    public void addFavorite(User user, Integer movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new IllegalArgumentException("Movie not found with id: " + movieId);
        }
        Movie movie = optionalMovie.get();
        boolean exists = favoriteRepository.existsByUserAndMovie(user, movie);
        if (!exists) {
            Favorite favorite = Favorite.builder()
                    .user(user)
                    .movie(movie)
                    .build();
            favoriteRepository.save(favorite);
        }
    }
    // Xóa phim khỏi danh sách yêu thích
    public void removeFavorite(User user, Integer movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new IllegalArgumentException("Movie not found with id: " + movieId);
        }
        Movie movie = optionalMovie.get();
        Optional<Favorite> favorite = favoriteRepository.findByUserAndMovie(user, movie);
        favorite.ifPresent(favoriteRepository::delete);
    }
    // Xóa toàn bộ phim yêu thích của user
    public void removeAllFavorites(User user) {
        favoriteRepository.deleteByUser(user);
    }
    // Kiểm tra phim có nằm trong danh sách yêu thích không
    public boolean isFavorite(User user, Integer movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.map(movie -> favoriteRepository.existsByUserAndMovie(user, movie))
                .orElse(false);
    }
}
