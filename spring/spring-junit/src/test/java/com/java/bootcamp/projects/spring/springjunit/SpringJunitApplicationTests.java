package com.java.bootcamp.projects.spring.springjunit;

import com.java.bootcamp.projects.spring.springjunit.service.CacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringJunitApplicationTests {

	@Autowired
	private CacheService cacheService;

	@Test
	void contextLoads() {

		assertTrue(cacheService.getSize() == 0);

		cacheService.put("s1", "value");
		Optional<String> value = cacheService.get("s1", String.class);

		assertTrue(cacheService.getSize() == 1);
		assertTrue(value.isPresent());
		assertEquals(value.get(), "value");

		value = cacheService.get("xx", String.class);
		assertFalse(value.isPresent());

		boolean removed = cacheService.remove("s1");
		assertTrue(removed);
		assertTrue(cacheService.getSize() == 0);

		removed = cacheService.remove("s1");
		assertFalse(removed);
		assertTrue(cacheService.getSize() == 0);

	}

}
