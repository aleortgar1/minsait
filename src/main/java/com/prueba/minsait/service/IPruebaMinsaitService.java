package com.prueba.minsait.service;

import com.prueba.minsait.model.dto.ms.DataMinsaitDTO;
import com.prueba.minsait.response.ms.respuestaDTO;


public interface IPruebaMinsaitService {

	public respuestaDTO getDataMinsait(DataMinsaitDTO dataminsaitRequestDTO);

}
