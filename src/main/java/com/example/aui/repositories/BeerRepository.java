package com.example.aui.repositories;

import com.example.aui.dtos.beer.UpdateBeerRequestDTO;
import com.example.aui.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BeerRepository extends JpaRepository<Beer, Long> {

    @Modifying
    @Query(value = "insert into public.beers (name, voltage, brand_id) values (:name, :voltage, :brandId)", nativeQuery = true)
    void create(@Param("name") String name, @Param("voltage") Double voltage, @Param("brandId") Long brandId);

    @Query(value = "select * from public.beers b where b.id = :id", nativeQuery = true)
    Beer read(@Param("id") Long id);

    @Query(value = "select * from public.beers", nativeQuery = true)
    List<Beer> readAll();

    @Modifying
    @Query(value = "update public.beers set name = :name, voltage = :voltage where public.beers.id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("name") String name, @Param("voltage") Double voltage);

    @Modifying
    @Query(value = "delete from public.beers where public.beers.id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);

    @Query(value = "select * from public.beers where public.beers.brand_id = :id", nativeQuery = true)
    List<Beer> searchAllByBrandId(@Param("id") Long id);

    @Modifying
    @Query(value = "delete from public.beers where public.beers.brand_id = :id", nativeQuery = true)
    void deleteAllByBrandId(@Param("id") Long id);
}
