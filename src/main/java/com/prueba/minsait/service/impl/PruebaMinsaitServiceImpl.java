package com.prueba.minsait.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.minsait.common.Constants;
import com.prueba.minsait.exception.RepositoryException;
import com.prueba.minsait.model.dto.ms.DataMinsaitDTO;
import com.prueba.minsait.model.entity.Minsait;
import com.prueba.minsait.repository.IMinsaitRepository;
import com.prueba.minsait.response.ms.MinsaitDTO;
import com.prueba.minsait.response.ms.errorDTO;
import com.prueba.minsait.response.ms.respuestaDTO;
import com.prueba.minsait.service.IPruebaMinsaitService;

@Service
public class PruebaMinsaitServiceImpl implements IPruebaMinsaitService {
	
	@Autowired
	private IMinsaitRepository minsaitRepository;

	@Override
	public respuestaDTO getDataMinsait(
			DataMinsaitDTO dataRequestDTO) {
			respuestaDTO respuesta = new respuestaDTO();
			errorDTO error = new errorDTO();
			Minsait prueba;
			MinsaitDTO data =  new MinsaitDTO();
			try {
				if(dataRequestDTO != null) {
				prueba = minsaitRepository.findById(dataRequestDTO.getIdCadena(), dataRequestDTO.getIdProducto(), dataRequestDTO.getFechaApp());
				if (prueba == null) {
					error.setCodigo(Constants.ERROR_500);
					respuesta.setError(error);
					respuesta.setData(null);
				} else {				
					data.setIdBrand(prueba.getIdBrand());
					data.setCurr(prueba.getCurr());
					data.setStartDate(prueba.getStartDate());
					data.setEndDate(prueba.getEndDate());
					data.setIdProduct(prueba.getIdProduct());
					data.setPrice(prueba.getPrice());
					data.setPriority(prueba.getPriority());
					data.setPriceList(prueba.getPriceList());
					respuesta.setData(data);
					respuesta.setError(null);
				}
				}
			} catch (RepositoryException e) {
				e.printStackTrace();
			}
		return respuesta;
	}

}
