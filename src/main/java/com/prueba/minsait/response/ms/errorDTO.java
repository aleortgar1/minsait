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
public class errorDTO {
    
    @JsonProperty(value = "codigo")
    private String codigo; 
    
    @JsonProperty(value = "mensage")
    private String mensage; 
}
