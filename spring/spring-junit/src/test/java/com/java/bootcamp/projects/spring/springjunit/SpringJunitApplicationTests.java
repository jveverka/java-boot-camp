package com.java.bootcamp.projects.spring.springjunit;

import com.java.bootcamp.projects.spring.springjunit.dto.ObjectKey;
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

		ObjectKey validKey = ObjectKey.from("s1");
		ObjectKey invalidKey = ObjectKey.from("xx");

		assertTrue(cacheService.getSize() == 0);

		cacheService.put(validKey, "value");
		Optional<String> value = cacheService.get(validKey, String.class);

		assertTrue(cacheService.getSize() == 1);
		assertTrue(value.isPresent());
		assertEquals(value.get(), "value");

		value = cacheService.get(invalidKey, String.class);
		assertFalse(value.isPresent());

		boolean removed = cacheService.remove(validKey);
		assertTrue(removed);
		assertTrue(cacheService.getSize() == 0);

		removed = cacheService.remove(validKey);
		assertFalse(removed);
		assertTrue(cacheService.getSize() == 0);

	}

}
