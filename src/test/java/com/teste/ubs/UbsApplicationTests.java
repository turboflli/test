package com.teste.ubs;

import com.teste.ubs.application.UbsApplication;
import com.teste.ubs.application.model.UbsEntity;
import com.teste.ubs.application.repositories.UbsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@AutoConfigurationPackage
@ContextConfiguration(classes= UbsApplicationTests.class)
@DataJpaTest
@TestPropertySource(locations = "/test.properties",
		properties = "baeldung.testpropertysource.one=other-property-value")
public class UbsApplicationTests {

	@Autowired
	UbsRepository ubsRepository;

	@Before
	public void setUp(){
		ubsRepository.save(new UbsEntity(1L,"ubs 1", "rua 1", "cidade 1","02", 45.1,
					23.1,1,2,3,1));
		ubsRepository.save(new UbsEntity(2L,"ubs 2", "rua 2", "cidade 2","02", 45.2,
				23.2,2,3,2,3));
		ubsRepository.save(new UbsEntity(3L,"ubs 3", "rua 3", "cidade 3","02", 45.3,
				23.3,3,1,1,2));
		ubsRepository.save(new UbsEntity(4L,"ubs 4", "rua 4", "cidade 4","02", 45.4,
				23.3,1,2,3,1));
		ubsRepository.save(new UbsEntity(5L,"ubs 5", "rua 5", "cidade 5","02", 45.5,
				23.5,2,3,2,3));
		ubsRepository.save(new UbsEntity(6L,"ubs 6", "rua 6", "cidade 6","02", 45.6,
				23.6,3,1,1,2));
		ubsRepository.save(new UbsEntity(7L,"ubs 7", "rua 7", "cidade 7","02", 45.7,
				23.7,1,2,3,1));
		ubsRepository.save(new UbsEntity(8L,"ubs 8", "rua 8", "cidade 8","02", 45.8,
				23.8,2,3,2,3));
		ubsRepository.save(new UbsEntity(9L,"ubs 9", "rua 9", "cidade 9","02", 45.9,
				23.9,3,1,1,2));
		ubsRepository.save(new UbsEntity(10L,"ubs 10", "rua 10", "cidade 10","02", 46.0,
				24.0,1,2,3,1));
	}



	@Test
	public void findAll() {
		Page<UbsEntity> resultado = ubsRepository.findByDistance(46.0, 23.0, PageRequest.of(0, 20));
		Assert.assertEquals(resultado.getTotalElements(), 10);
	}


	public void verifyPageNumber() {
		Page<UbsEntity> resultado = ubsRepository.findByDistance(46.0, 23.0, PageRequest.of(0, 5));
		Assert.assertEquals(resultado.getTotalElements(), 10);
		Assert.assertEquals(resultado.getContent().size(), 5);
	}


	public void findByPageAndDistance() {
		Page<UbsEntity> resultado = ubsRepository.findByDistance(45.59, 23.59, PageRequest.of(1, 3));
		Assert.assertEquals(resultado.getTotalElements(), 10);
		UbsEntity ubsEncontrada = resultado.getContent().get(0);//4 elemento
		Assert.assertEquals(ubsEncontrada.getName(), "ubs 8");
	}

}
