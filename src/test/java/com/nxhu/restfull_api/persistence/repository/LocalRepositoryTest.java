package com.nxhu.restfull_api.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.nxhu.restfull_api.persistence.entity.LocalEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LocalRepositoryTest {
	private LocalEntity local12;
	@Autowired
	private ILocalRepository localRepository;
	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() {
//		When
		local12 = LocalEntity.builder().name("local 12").floor("piso 12").build();
		testEntityManager.persist(local12);
	}

	@Test
	@DisplayName("findByNameIngoreCase should return 'local 12'")
	void testFindByNameIgnoreCaseFound() {
//		Given
		Optional<LocalEntity> actual = localRepository.findByNameIgnoreCase("LocAl 12");
//		Then
		LocalEntity expected = local12; 
		assertEquals(expected, actual.get());
	}
	
	@Test
	@DisplayName("findByNameIngoreCase should return empty")
	void testFindByNameIgnoreCaseNotFound() {
//		Given
		Optional<LocalEntity> actual = localRepository.findByNameIgnoreCase("LocAl 20");
	
//		Then
		Optional<Object> expected = Optional.empty();
		assertEquals(expected, actual);
	}
}
