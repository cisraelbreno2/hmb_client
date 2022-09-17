package br.com.hmb_client.repository;

import br.com.hmb_client.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {

    @Query("SELECT c FROM CityModel c WHERE c.id = :id")
    List<CityModel> getAllByState(@Param("id") Long id);
}
