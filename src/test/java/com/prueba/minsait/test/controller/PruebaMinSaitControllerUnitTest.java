package com.prueba.minsait.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.prueba.minsait.controller.PruebaMinSaitController;
import com.prueba.minsait.model.dto.ms.DataMinsaitDTO;
import com.prueba.minsait.model.entity.Minsait;
import com.prueba.minsait.repository.MinsaitRepository;
import com.prueba.minsait.response.ms.respuestaDTO;
import com.prueba.minsait.service.impl.PruebaMinsaitServiceImpl;

@WebMvcTest(controllers = PruebaMinSaitController.class)
@Import(PruebaMinSaitController.class)
@AutoConfigureMockMvc(addFilters = true)
@ContextConfiguration(classes = { ConfiguradorSpring.class })
class PruebaMinSaitControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	@MockBean
	private PruebaMinsaitServiceImpl pruebaMinsaitService;
	
	@Autowired
	@MockBean
	private MinsaitRepository minsaitRepository;
	
	@Test
	void testing_getDataMinsait() throws Exception {
		respuestaDTO respuesta = new respuestaDTO();
		Minsait minsait = new Minsait();
		DataMinsaitDTO dto = new DataMinsaitDTO();
		String mockValueParamfechaApp = "2020-06-14-10.00.00";
		String mockValueParamidProducto = "35455";
		String mockValueParamidcadena = "1";
		
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/minsait")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andReturn();
		Mockito.when(minsaitRepository.findById(mockValueParamidcadena, mockValueParamidProducto, mockValueParamfechaApp)).thenReturn(minsait("1", "35455", "1", "2020-06-14-00.00.00", "2020-12-31-23.59.59", "0", "35.50", "EUR"));
		pruebaMinsaitService.getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
		verify(pruebaMinsaitService, times(1)).getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
	}
	
	@Test
	void testing_getDataMinsait1() throws Exception {
		respuestaDTO respuesta = new respuestaDTO();
		Minsait minsait = new Minsait();
		DataMinsaitDTO dto = new DataMinsaitDTO();
		String mockValueParamfechaApp = "2020-06-14-16.00.00";
		String mockValueParamidProducto = "35455";
		String mockValueParamidcadena = "1";
		
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/minsait")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andReturn();
		Mockito.when(minsaitRepository.findById(mockValueParamidcadena, mockValueParamidProducto, mockValueParamfechaApp)).thenReturn(minsait("1", "35455", "1", "2020-06-14-15.00.00", "2020-06-14-18.30.00", "1", "25.45", "EUR"));
		pruebaMinsaitService.getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
		verify(pruebaMinsaitService, times(1)).getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
	}
	
	@Test
	void testing_getDataMinsait2() throws Exception {
		respuestaDTO respuesta = new respuestaDTO();
		Minsait minsait = new Minsait();
		DataMinsaitDTO dto = new DataMinsaitDTO();
		String mockValueParamfechaApp = "2020-06-14-21.00.00";
		String mockValueParamidProducto = "35455";
		String mockValueParamidcadena = "1";
		
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/minsait")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andReturn();
		Mockito.when(minsaitRepository.findById(mockValueParamidcadena, mockValueParamidProducto, mockValueParamfechaApp)).thenReturn(minsait("1", "35455", "1", "2020-06-14-00.00.00", "2020-12-31-23.59.59", "0", "35.50", "EUR"));
		pruebaMinsaitService.getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
		verify(pruebaMinsaitService, times(1)).getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
	}
	
	@Test
	void testing_getDataMinsait3() throws Exception {
		respuestaDTO respuesta = new respuestaDTO();
		Minsait minsait = new Minsait();
		DataMinsaitDTO dto = new DataMinsaitDTO();
		String mockValueParamfechaApp = "2020-06-15-10.00.00";
		String mockValueParamidProducto = "35455";
		String mockValueParamidcadena = "1";
		
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/minsait")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andReturn();
		Mockito.when(minsaitRepository.findById(mockValueParamidcadena, mockValueParamidProducto, mockValueParamfechaApp)).thenReturn(minsait("1", "35455", "1", "2020-06-15-00.00.00", "2020-06-15-11.00.00", "1", "35.50", "EUR"));
		pruebaMinsaitService.getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
		verify(pruebaMinsaitService, times(1)).getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
	}
	
	@Test
	void testing_getDataMinsait4() throws Exception {
		respuestaDTO respuesta = new respuestaDTO();
		Minsait minsait = new Minsait();
		DataMinsaitDTO dto = new DataMinsaitDTO();
		String mockValueParamfechaApp = "2020-06-16-21.00.00";
		String mockValueParamidProducto = "35455";
		String mockValueParamidcadena = "1";
		
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/minsait")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andReturn();
		Mockito.when(minsaitRepository.findById(mockValueParamidcadena, mockValueParamidProducto, mockValueParamfechaApp)).thenReturn(minsait("1", "35455", "1", "2020-06-15-16.00.00", "2020-12-31-23.59.59", "1", "38.95", "EUR"));
		pruebaMinsaitService.getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
		verify(pruebaMinsaitService, times(1)).getDataMinsait(castToDataMinsaitDto(mockValueParamfechaApp, mockValueParamidProducto, mockValueParamidcadena));
	}
	
	private DataMinsaitDTO castToDataMinsaitDto(String mockValueParamfechaApp, String mockValueParamidProducto, String mockValueParamidcadena) {
		DataMinsaitDTO data = new DataMinsaitDTO();
		if(null != mockValueParamfechaApp && null != mockValueParamidProducto && null != mockValueParamidcadena) {
			data.setFechaApp(mockValueParamfechaApp);
			data.setIdCadena(mockValueParamidcadena);
			data.setIdProducto(mockValueParamidProducto);
		}
		return data;
	}
	
	private Minsait minsait(String a, String b, String c, String d, String e, String f, String g, String h) {
		Minsait minsait = new Minsait();
		minsait.setCurr(h);
		minsait.setEndDate(e);
		minsait.setIdBrand(a);
		minsait.setIdProduct(b);
		minsait.setPrice(g);
		minsait.setPriceList(c);
		minsait.setPriority(f);
		minsait.setStartDate(d);
		return minsait;
	}
}
