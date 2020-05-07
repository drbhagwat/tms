package com.s3group.tmsapi.core.repo;


import com.s3group.tmsapi.core.entities.WarehouseKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This represents repository for Warehouse entity.
 *
 * @author : Thamilarasi
 * @version : 2.0
 * @since : 2020-05-06
 */
@Repository
public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, WarehouseKey> {
  /**
   * Finds all warehouses.
   *
   * @return - all warehouses in the database.
   */
  Page<Warehouse> findAll(Pageable pageable);
}
