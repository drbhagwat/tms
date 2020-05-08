package com.s3group.tmsapi.jpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Puts auditing information (i.e., the currently logged in giv user as the Created User and/or Updated User.
 * Also puts the current system date & time as the Created DateTime and/or Updated DateTime for all db records.
 *
 * @author : Dinesh Bhagwat
 * @version : 1.0
 * @since : 2019-04-15
 */



@Component
public class AuditorAwareImpl implements AuditorAware<String> {
/*
  @Autowired
  JwtRequestFilter jwtRequestFilter;
*/

  @Override
  public Optional<String> getCurrentAuditor() {
//    String userName = jwtRequestFilter.getUserName();
    String userName = "Tenant1";

    if (userName == null) {
      throw new RuntimeException("Unauthorized User");
    }
    return Optional.of(userName);
//    return Optional.of(jwtRequestFilter.getUserName());
  }
}

