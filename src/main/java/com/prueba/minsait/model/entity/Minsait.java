package com.prueba.minsait.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Getter 
@Setter
public class Minsait implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idBrand;
	
	@Column(name = "idproduct")
    private String idProduct;
    
	@Column(name = "pricelist")
    private String priceList;

	@Column(name = "startdate")
    private String startDate;
    
	@Column(name = "enddate")
    private String endDate;
    
	@Column(name = "priority")
    private String priority;

	@Column(name = "price")
    private String price;

	@Column(name = "curr")
    private String curr;

}
