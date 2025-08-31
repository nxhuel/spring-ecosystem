package com.nxhu.restfull_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.nxhu.restfull_api.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.persistence.repository.ILocalRepository;

@SpringBootTest
class ILocalServiceTest {

	private LocalEntity localUno;
	@Autowired
	private ILocalService localService;
	@MockitoBean
	private ILocalRepository localRepository;

	@BeforeEach
	void setUp() {
//		When
		localUno = LocalEntity.builder().idLocal(1L).name("local 1").floor("piso 1").build();
	}

	@Test
	@DisplayName("findByNameIgnoreCase should return object LocalEntity localUno with correct parameter")
	void testFindByNameIgnoreCaseFound() {
//		When
		String localName = "lOcAl 1";
		Mockito.when(localRepository.findByNameIgnoreCase(localName)).thenReturn(Optional.of(localUno));
		LocalEntity actual = localService.findByNameIgnoreCase(localName).get();
//		Given
		LocalEntity expected = localUno;
//		Then
		assertEquals(expected, actual);
//		Logs
		System.out.println("Logs -> Expected: " + expected);
		System.out.println("Logs -> Actual: " + actual);
	}
	
	@Test
	@DisplayName("findByNameIgnoreCase should return empty with search local not exist")
	void testFindByNameIgnoreCaseNotFound() {
//		When
		String localName = "Cine 12";
		Mockito.when(localRepository.findByNameIgnoreCase(localName)).thenReturn(Optional.empty());
		Optional<LocalEntity> actual = localService.findByNameIgnoreCase(localName);
//		Given
		Optional<Object>  expected = Optional.empty();
//		Then
		assertEquals(expected, actual);
//		Logs
		System.out.println("Logs -> Expected: " + expected);
		System.out.println("Logs -> Actual: " + actual);
	}
}
