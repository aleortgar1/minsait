package com.prueba.minsait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.minsait.common.Constants;
import com.prueba.minsait.common.HttpStatusConstants;
import com.prueba.minsait.model.dto.ms.DataMinsaitDTO;
import com.prueba.minsait.response.ms.errorDTO;
import com.prueba.minsait.response.ms.respuestaDTO;
import com.prueba.minsait.service.IPruebaMinsaitService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("api")
public class PruebaMinSaitController {

	@Autowired
	public IPruebaMinsaitService pruebaMinSaitService;

	@PostMapping(value = "/minsait", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<respuestaDTO> getDataMinsait(@Parameter String fechaApp, @Parameter String idProducto, @Parameter String idcadena){
		ResponseEntity<respuestaDTO> responseEntity = null;
		if(fechaApp != null && idProducto != null && idcadena != null) {			
		DataMinsaitDTO datos = new DataMinsaitDTO();
		datos.setFechaApp(fechaApp);
		datos.setIdCadena(idcadena);
		datos.setIdProducto(idProducto);
		respuestaDTO response = pruebaMinSaitService.getDataMinsait(datos);
			if (null == response.getError()) {
				response.setData(response.getData());
				response.setError(new errorDTO(Constants.ERROR_200, HttpStatusConstants.OK_MESSAGE));
				responseEntity = new ResponseEntity<>(new respuestaDTO(response.getData(), response.getError()), HttpStatus.OK);
			} else {
				response.setData(null);
				response.setError(new errorDTO(response.getError().getCodigo(), HttpStatusConstants.INTERNAL_SERVER_ERROR_MESSAGE));
				responseEntity = new ResponseEntity<>(new respuestaDTO(response.getData(), response.getError()), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}	
		return responseEntity;
	}
}
