package com.teste.ubs.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UbsApplication  extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(UbsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(UbsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UbsApplication.class);
	}

//	@Bean
//	public CommandLineRunner demo(UbsRepository ubsRepository) {
//		return (args) -> {
//			ubsRepository.save(new UbsEntity(1L,"ubs 1", "rua 1", "cidade 1","02", 45.268,
//					23.258,1,2,3,1));
//			ubsRepository.save(new UbsEntity(2L,"ubs 2", "rua 2", "cidade 2","04", 45.268,
//					23.258,2,2,1,3));
//			log.info("Salvando .....");
//			Pageable paging = PageRequest.of(0, 3);
//			Page<UbsEntity> page = ubsRepository.findByDistance(45.268, 23.258, paging  );
//			log.info("Totais encontrados : "+page.getTotalElements());
//			page.get().forEach( ubsEntity -> {
//				log.info("ubs: "+ubsEntity.toString());
//			});
//
//
//		};
//	}

}
