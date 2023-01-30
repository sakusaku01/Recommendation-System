package kg.megacom.Recommendation.system.Recommendation.system.repository;

import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Popular;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularRepository extends JpaRepository<Popular,Long> {

    @Query(value ="select  m.name as music ," +
            "            MIN(a.name) as author , al.name as album ," +
            "             p.add_date as addDate,m.duration , p.order_num as orderNum from tb_popular p" +
            "            join tb_music m on m.id = p.music_id " +
            "             join tb_album al on al.id = m.album_id " +
            "             join tb_music_author tma on m.id = tma.music_id " +
            "             join tb_author a on a.id = tma.autor_id " +
            "group by music,album,addDate, m.duration, orderNum " +
            "order by orderNum",nativeQuery = true )
    List<MusicRepoResponse> findAllByOrderNum();

}
