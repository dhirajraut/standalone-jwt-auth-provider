package com.galaxy.auth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.galaxy.auth.JwtClaims;
import com.galaxy.auth.StandaloneJwtAuthProvider;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StandaloneJwtAuthProviderTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() {
		// Keeping it blank for this exercise.
	}

	/**
	 * Teardown required environment.
	 */
	@After
	public void tearDown() {
		// Keeping it blank for this exercise.
	}

	@Test
	public void testValidToken() throws InterruptedException {

		JwtClaims jwtClaims = JwtClaims.builder().timeoutInSeconds(5).userId("Dhiraj").locale("en-us").build();
		String generatedToken = StandaloneJwtAuthProvider.generateToken(jwtClaims);
		log.info("Token = " + generatedToken);
		Assert.isTrue(StandaloneJwtAuthProvider.verifyToken(generatedToken, jwtClaims));
	}

	@Test
	public void testExpiredToken() throws InterruptedException {

		expectedException.expect(ExpiredJwtException.class);

		JwtClaims jwtClaims = JwtClaims.builder().timeoutInSeconds(2).userId("Dhiraj").locale("en-us").build();
		String generatedToken = StandaloneJwtAuthProvider.generateToken(jwtClaims);
		log.info("Token = " + generatedToken);
		Thread.sleep(5000);
		StandaloneJwtAuthProvider.verifyToken(generatedToken, jwtClaims);
	}
}
