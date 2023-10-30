package com.prueba.minsait.model.dto.ms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataMinsaitDTO {

	@JsonProperty(value = "fechaApp")
    private String fechaApp;
	
    @JsonProperty(value = "idProducto")
    private String idProducto;

    @JsonProperty(value = "idCadena")
    private String idCadena;
    
}
