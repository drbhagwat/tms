/*
package com.s3group.tmsapi.service;

import com.s3group.tmsapi.config.multitenant.TenantContext;
import com.s3group.tmsapi.entities.City;
import com.s3group.tmsapi.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  @Autowired
  public EntityManager entityManager;

  public void save(City city) {
    cityRepository.save(city);
  }

  public List<City> getAll() throws SQLException {
    return cityRepository.findByTenantId(TenantContext.getCurrentTenant());
  }

  public City get(Long id) {
    return cityRepository.findById(id).get();
  }

  public City getByName(String name) {
    return cityRepository.findByName(name);
  }

  public void delete(String name) {
    cityRepository.deleteByName(name);
  }
}
*/
