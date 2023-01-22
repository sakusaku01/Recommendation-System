package kg.megacom.Recommendation.system.Recommendation.system.services;

import java.util.List;

public interface BaseServices <T>{
    T save(T t,int lang);
    T findById(Long id,int lang);
    List<T> findAll(int lang);
}
