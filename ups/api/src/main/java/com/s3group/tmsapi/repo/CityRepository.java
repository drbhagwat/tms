//package com.s3group.tmsapi.repo;
//
//import com.s3group.tmsapi.entities.City;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CityRepository extends JpaRepository<City, Long> {
//  Optional<City> findById(Long id);
//
//  List<City> findByTenantId(String tenantId);
//
//  City findByName(String name);
//
//  void deleteByName(String name);
//}
