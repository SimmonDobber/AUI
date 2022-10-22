package com.example.aui.repositories;

import com.example.aui.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Modifying
    @Query(value = "insert into public.brands (name, rating) values (:name, :rating)", nativeQuery = true)
    void create(@Param("name") String name, @Param("rating") Double rating);

    @Query(value = "select * from public.brands b where b.id = :id", nativeQuery = true)
    Brand read(@Param("id") Long id);

    @Query(value = "select * from public.brands", nativeQuery = true)
    List<Brand> readAll();

    @Modifying
    @Query(value = "update public.brands set name = :name, rating = :rating where PUBLIC.brands.id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("name") String name, @Param("rating") Double rating);

    @Modifying
    @Query(value = "delete from public.brands where public.brands.id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);
}
