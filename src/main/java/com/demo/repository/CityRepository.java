package com.demo.repository;

import com.demo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface CityRepository   extends JpaRepository<City,Long>{

    @Transactional
    @Modifying
    @Query("update City c set c.name = :name, c.country.id =:country_id WHERE c.id = :city_id")
    public int updateCity(@Param("city_id") Long id, @Param("country_id") Long countryId ,@Param("name") String name);


}
