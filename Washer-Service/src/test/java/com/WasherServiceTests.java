package com;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Washer;
import com.repository.WasherRepository;
import com.service.WasherService;

@SpringBootTest
class WasherServiceTests {

	@Autowired
	private WasherService washerService;

	@MockBean
	private WasherRepository washerRepository;

	@Test
	public void addWasherTest() {
		Washer c = new Washer();
		c.setId(100);
		c.setName("Narendra");
		c.setLocation("Hyderabad");
		c.setPassword("XYZ123#");
		

		Mockito.when(washerRepository.save(c)).thenReturn(c);
		assertThat(washerService.addWasher(c)).isEqualTo(c);
	}

	@Test
	public void getAllWahersTest() {
		Washer c = new Washer();
		c.setId(100);
		c.setName("Narendra");
		c.setLocation("Hyderabad");
		c.setPassword("XYZ123#");

		Washer c1 = new Washer();
		c1.setId(100);
		c1.setName("Narendra");
		c1.setLocation("Hyderabad");
		c1.setPassword("XYZ123#");

		List<Washer> w = new ArrayList<>();
		w.add(c1);
		w.add(c);

		Mockito.when(washerRepository.findAll()).thenReturn(w);
		assertThat(washerService.getAllWashers()).isEqualTo(w);
	}

	@Test
	public void getWasherTest() {
		Washer c = new Washer();
		c.setId(100);
		c.setName("Narendra");
		c.setLocation("Hyderabad");
		c.setPassword("XYZ123#");


		Mockito.when(washerRepository.findById(100).get()).thenReturn(c);
		assertThat(washerService.getWasherById(100)).isEqualTo(c);
	}

}
