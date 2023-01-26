package kg.megacom.Recommendation.system.Recommendation.system.repository;

import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {


    @Query( value = "select m.name as music , a.name as author , al.name as album ," +
            "m.add_date , m.duration from tb_music m join tb_album al on al.id = m.album_id " +
            "join tb_music_author ma on m.id = ma.music_id join tb_author a on a.id = ma.autor_id where a.name=?1 ", nativeQuery = true)
    List<MusicRepoResponse> findMusicRepo(String authorName);
}
