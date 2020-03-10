package com.galaxy.auth.standalone_jwt_auth_provider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.galaxy.auth.JwtClaims;
import com.galaxy.auth.StandaloneJwtAuthProvider;

import io.jsonwebtoken.lang.Assert;

public class StandaloneJwtAuthProviderTest {

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
	public void testValidToken() {

		JwtClaims jwtClaims = JwtClaims.builder().userId("Dhiraj").locale("en-us").build();
		String generatedToken = StandaloneJwtAuthProvider.generateToken(jwtClaims);
		System.out.println("Token = " + generatedToken);
		Assert.isTrue(StandaloneJwtAuthProvider.verifyToken(generatedToken, jwtClaims));
	}

}
