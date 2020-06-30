package com.s3group.tmsapi.common.repo;

import com.s3group.tmsapi.common.entities.ShipFrom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This represents the repository for shipper entity.
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-06-22
 */
@Repository
public interface ShipFromRepository extends PagingAndSortingRepository<ShipFrom, String> {
   ShipFrom findFirstByPhone_Number(String shipFromPhoneNumber);
}
