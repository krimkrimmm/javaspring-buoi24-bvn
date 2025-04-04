package vn.scrip.buoi24.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "favorites", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "movie_id"}))
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;
}
