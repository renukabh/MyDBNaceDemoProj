package com.db.clm;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.clm.model.Nace;
import com.db.clm.repository.NaceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NaceRepositoryTests {

	@Autowired
	private NaceRepository naceRepository;

	//Junit test for save Nace object.. 
	@Test
	public void saveNaceTest() {
		Nace nace = new Nace();
		nace.setLevel(1);
		nace.setCode("A");
		nace.setDescription("AGRICULTURE, FORESTRY AND FISHING");
		nace.setReferenceRev("A");
		naceRepository.save(nace);
		Assertions.assertThat(nace.getOrder()).isGreaterThan(0);
		Assertions.assertThat(nace.getCode()).isEqualTo("A");
	}
}
