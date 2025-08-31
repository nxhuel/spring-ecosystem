package com.nxhu.restfull_api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.nxhu.restfull_api.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.service.ILocalService;

@WebMvcTest(LocalController.class)
class LocalControllerTest {
	private LocalEntity localUno;
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ILocalService localService;

	@BeforeEach
	void setUp() {
		localUno = LocalEntity.builder().idLocal(1L).name("local 1").floor("piso 1").build();
	}

	@Test
	void testSaveLocal() throws Exception {
		LocalEntity postLocalUno = LocalEntity.builder().name("local 1").floor("piso 1").build();
		Mockito.when(localService.saveLocal(postLocalUno)).thenReturn(localUno);
		mockMvc.perform(post("/api/v1/local").contentType(MediaType.APPLICATION_JSON)
				  .content(	"{\n" +
						  	"\"name\":\"local 1\",\n" +
				             "\"floor\": \"piso 1\",\n" +
				             "}"))
					.andExpect(status().isCreated());
	}

}
