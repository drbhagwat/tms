package com.s3group.tmsapi.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This class represents CarrierServiceCode entity
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-06
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CarrierServiceCode extends BasicLogger<String> {
    @Id
    private String carrierCode;

    private String carrierShipmentService;

    private String description;
}