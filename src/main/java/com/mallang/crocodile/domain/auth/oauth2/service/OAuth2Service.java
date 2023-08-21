package com.mallang.crocodile.domain.auth.oauth2.service;

import com.mallang.crocodile.domain.auth.user.dto.User;

public interface OAuth2Service {
	String getAuthorizeUrl();
	String getAccessToken(String code);
	User getUser(String accessToken);
}
