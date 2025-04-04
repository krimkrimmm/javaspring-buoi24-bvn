package vn.scrip.buoi24.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.scrip.buoi24.service.FavoriteMovieService;
import vn.scrip.buoi24.entity.Movie;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FavoriteWebController {
    private final FavoriteMovieService favoriteMovieService;

    @GetMapping("/favorites")
    public String getFavoriteMovies(Model model) {
        List<Movie> favoriteMovies = favoriteMovieService.getUserFavorites();
        model.addAttribute("favoriteMovies", favoriteMovies);
        return "web/favorites";
    }
}
