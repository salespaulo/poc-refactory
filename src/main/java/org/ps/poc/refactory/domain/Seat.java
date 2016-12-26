package org.ps.poc.refactory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Table(name="seat")
public class Seat {

	@Id
	@Column(nullable=false, unique=true)
	private Integer id;
	
	@Column(name="tp_seat", nullable=false)
	private String type;

}
