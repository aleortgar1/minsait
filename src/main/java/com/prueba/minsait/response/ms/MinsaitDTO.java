package com.prueba.minsait.response.ms;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinsaitDTO {

	@JsonProperty(value = "idBrand")
    private String idBrand;
	
    @JsonProperty(value = "idProduct")
    private String idProduct;
    
    @JsonProperty(value = "priceList")
    private String priceList;

    @JsonProperty(value = "startDate")
    private String startDate;
    
    @JsonProperty(value = "endDate")
    private String endDate;
    
    @JsonProperty(value = "priority")
    private String priority;

    @JsonProperty(value = "price")
    private String price;
    
    @JsonProperty(value = "curr")
    private String curr;
}
