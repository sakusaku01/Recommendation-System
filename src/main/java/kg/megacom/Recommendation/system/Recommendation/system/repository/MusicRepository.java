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
public interface MusicRepository extends JpaRepository<Music,Long> , JpaSpecificationExecutor<Music> {


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


    static Specification<Music> hasAuthor(String author) {
        return (music, cq, cb) -> cb.equal(music.get("authorId"), author);
    }

    static Specification<Music> hasGenre(String genre) {
        return (music, cq, cb) -> cb.like(music.get("genreId"), "%" + genre + "%");
    }
    static Specification<Music> hasName(String musicName) {
        return (music, cq, cb) -> cb.equal(music.get("name"), musicName);
    }
}
