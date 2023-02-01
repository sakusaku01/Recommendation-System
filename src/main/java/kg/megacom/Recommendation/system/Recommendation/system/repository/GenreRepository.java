package kg.megacom.Recommendation.system.Recommendation.system.repository;

import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    @Query(value = "select distinct g.* from tb_genre g " +
            "join tb_music_genre tmg on g.id = tmg.genre_id " +
            "join tb_music tm on tm.id = tmg.music_id where tm.id=?1",nativeQuery = true)
    List<Genre> findByGenre(Long id);

}
