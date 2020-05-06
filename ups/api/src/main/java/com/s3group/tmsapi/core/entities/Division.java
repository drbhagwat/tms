package com.s3group.tmsapi.core.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.s3group.tmsapi.entities.request.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class represents Division entity
 *
 * @author : Dinesh Bhagwat
 * @version : 1.0
 * @since : 2019-04-15
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Division extends BasicLogger<String>  {
	@EmbeddedId
	@JsonUnwrapped
	@Valid
	DivisionKey id;

	@NotNull(message = "{NAME_MANDATORY}")
	@NotBlank(message = "{NAME_CANNOT_BE_BLANK}")
	private String name;

	@NotNull(message = "{DESCRIPTION_MANDATORY}")
	@NotBlank(message = "{DESCRIPTION_CANNOT_BE_BLANK}")
	private String description;

	private Address address;

	@NotNull(message = "{CONTACT_NAME_MANDATORY}")
	@NotBlank(message = "{CONTACT_NAME_CANNOT_BE_BLANK}")
	private String contactName;

	@NotNull(message = "{CONTACT_NUMBER_MANDATORY}")
	@NotBlank(message = "{CONTACT_NUMBER_CANNOT_BE_BLANK}")
	private String contactNumber;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Company company;
}