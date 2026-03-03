package com.ndduroc.rocmovies;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class RocmoviesApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true, "Application context loaded successfully!");
	}
}