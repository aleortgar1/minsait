package com.prueba.minsait.exception;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinsaitError {

	@JsonProperty(value = "idBrand")
    private String idBrand;
	
    @JsonProperty(value = "idProduct")
    private String idProduct;

    @JsonProperty(value = "idString")
    private String idString;
    
    @JsonProperty(value = "priceList")
    private List<String> priceList;

    @JsonProperty(value = "startDate")
    private Date startDate;
    
    @JsonProperty(value = "endDate")
    private Date endDate;
    
    @JsonProperty(value = "priority")
    private String priority;

    @JsonProperty(value = "price")
    private String price;
    
    @JsonProperty(value = "curr")
    private String curr;
    
    @JsonProperty(value = "respuesta")
    private String respuesta; 
}