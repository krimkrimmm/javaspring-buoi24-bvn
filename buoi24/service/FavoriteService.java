package vn.scrip.buoi24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.scrip.buoi24.entity.Favorite;
import vn.scrip.buoi24.entity.Movie;
import vn.scrip.buoi24.entity.User;
import vn.scrip.buoi24.repository.FavoriteRepository;
import vn.scrip.buoi24.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final MovieRepository movieRepository;

    public List<Favorite> getFavorites(User user) {
        return favoriteRepository.findByUser(user);
    }

    public void addFavorite(User user, Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        if (!favoriteRepository.existsByUserAndMovie(user, movie)) {
            Favorite favorite = Favorite.builder()
                    .user(user)
                    .movie(movie)
                    .build();
            favoriteRepository.save(favorite);
        }
    }

    public void removeFavorite(User user, Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        favoriteRepository.deleteByUserAndMovie(user, movie);
    }

    public void removeAllFavorites(User user) {
        favoriteRepository.deleteByUser(user);
    }

    public boolean isFavorite(User user, Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return favoriteRepository.existsByUserAndMovie(user, movie);
    }
}
