package com.nxhu.restfull_api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nxhu.restfull_api.persistence.entity.ArticleEntity;
import com.nxhu.restfull_api.persistence.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class RestfullApiApplication implements CommandLineRunner {
	
	private final ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestfullApiApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		List<ArticleEntity> articleEntities = Arrays.asList(
			    new ArticleEntity(null, "Universo I", "Información de distintos autores acerca del universo", 299, LocalDate.of(2007, 12, 3)),
			    new ArticleEntity(null, "Tecnología del Futuro", "Un vistazo a las tendencias tecnológicas del próximo siglo", 412, LocalDate.of(2020, 5, 21)),
			    new ArticleEntity(null, "Historia del Arte", "Un recorrido por las corrientes artísticas más influyentes", 350, LocalDate.of(2015, 8, 14)),
			    new ArticleEntity(null, "Inteligencia Artificial", "Cómo la IA está cambiando la forma en que vivimos", 287, LocalDate.of(2021, 3, 10)),
			    new ArticleEntity(null, "El Océano Profundo", "Descubrimientos recientes en las profundidades marinas", 198, LocalDate.of(2018, 11, 30)),
			    new ArticleEntity(null, "Energías Renovables", "El futuro sostenible a través de la innovación energética", 264, LocalDate.of(2019, 6, 17)),
			    new ArticleEntity(null, "Cerebro Humano", "Estudios sobre la mente y su funcionamiento", 322, LocalDate.of(2016, 9, 25)),
			    new ArticleEntity(null, "Programación Moderna", "Buenas prácticas en desarrollo de software actual", 410, LocalDate.of(2022, 1, 12)),
			    new ArticleEntity(null, "Viaje al Espacio", "Exploración espacial y proyectos de colonización", 376, LocalDate.of(2014, 4, 2)),
			    new ArticleEntity(null, "Psicología del Color", "Cómo los colores influyen en las emociones y decisiones", 241, LocalDate.of(2017, 7, 9)),
			    new ArticleEntity(null, "Big Data y Sociedad", "El impacto de los datos masivos en el mundo moderno", 315, LocalDate.of(2021, 10, 5)),
			    new ArticleEntity(null, "Cocina del Mundo", "Sabores, culturas y tradiciones gastronómicas", 280, LocalDate.of(2013, 2, 18)),
			    new ArticleEntity(null, "Arquitectura Sostenible", "Diseños ecoeficientes para un planeta más verde", 299, LocalDate.of(2020, 9, 3)),
			    new ArticleEntity(null, "Historia de Internet", "De los primeros protocolos al metaverso", 330, LocalDate.of(2019, 12, 7)),
			    new ArticleEntity(null, "Nanotecnología", "Aplicaciones en medicina, industria y electrónica", 268, LocalDate.of(2018, 1, 22)),
			    new ArticleEntity(null, "Filosofía Moderna", "Pensadores contemporáneos y sus teorías", 354, LocalDate.of(2012, 6, 15)),
			    new ArticleEntity(null, "Robótica Avanzada", "Robots colaborativos y su rol en la industria 4.0", 295, LocalDate.of(2023, 2, 27)),
			    new ArticleEntity(null, "Cambio Climático", "Evidencias, consecuencias y acciones urgentes", 310, LocalDate.of(2016, 11, 8)),
			    new ArticleEntity(null, "Economía Digital", "El auge de las criptomonedas y los mercados online", 340, LocalDate.of(2022, 4, 11)),
			    new ArticleEntity(null, "Ciberseguridad", "Protección de datos y amenazas modernas", 280, LocalDate.of(2021, 8, 19)),
			    new ArticleEntity(null, "Neurociencia Aplicada", "Investigaciones sobre aprendizaje y memoria", 355, LocalDate.of(2019, 3, 27))
			);
				
		articleRepository.saveAll(articleEntities);
	}
}
