package kg.megacom.Recommendation.system.Recommendation.system.repository;

import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    @Query(value = "select * from tb_user where email=?1",nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
