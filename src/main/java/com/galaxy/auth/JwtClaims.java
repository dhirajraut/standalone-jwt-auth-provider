package com.galaxy.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtClaims {

	private String userId;
	private String locale;
	private int timeoutInSeconds;
}
