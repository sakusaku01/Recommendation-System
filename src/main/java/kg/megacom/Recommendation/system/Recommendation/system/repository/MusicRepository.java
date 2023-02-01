package kg.megacom.Recommendation.system.Recommendation.system.repository;

import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Author;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Genre;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {


    @Query( value = "select m.name as music , a.name as author , al.name as album ," +
            "m.add_date , m.duration from tb_music m join tb_album al on al.id = m.album_id " +
            "join tb_music_author ma on m.id = ma.music_id join tb_author a on a.id = ma.autor_id where a.name=?1 ", nativeQuery = true)
    List<MusicRepoResponse> findMusicRepo(String authorName);
    @Query( value = "select m.name as music , a.name as author , al.name as album ," +
            "m.add_date as date ,m.duration as duration from tb_music m join tb_album al on al.id = m.album_id " +
            "join tb_music_author ma on m.id = ma.music_id join tb_author a on a.id = ma.autor_id where m.name=?1 ", nativeQuery = true)
    List<MusicRepoResponse>  findByName(String name);

    @Query("select m from Music m join Author a where a.name = '1324' ")
    List<Music> findByAuthorName(String name);
    @Query(value = "select * from tb_music m where m.name=?1",nativeQuery = true)
    List<Music> findByNameMusic(String musicName);

    @Query(value = "select * from tb_music m join tb_music_author tma on m.id = tma.music_id join tb_author ta on ta.id = tma.autor_id where ta.name=?1",nativeQuery = true)
    List<Music> findByAuthor(String authorName);

    @Query(value = "select * from tb_music m join tb_music_genre tmg on m.id = tmg.music_id join tb_genre tg on tg.id = tmg.genre_id where tg.name=?1",nativeQuery = true)
    List<Music> findByGenre(String genreName);

    @Query(value = "select distinct m.* from tb_music m join tb_music_genre tmg on m.id = tmg.music_id " +
            "join tb_genre tg on tg.id = tmg.genre_id where tg.id=?1",nativeQuery = true)
    List<Music> findMusicByGenre(Long id);

    @Query(value = "select m.* from tb_music m join tb_favorites tf on m.id = tf.music_id where tf.user_id=?1",nativeQuery = true)
    List<Music> findByMusic(Long userId);
}
