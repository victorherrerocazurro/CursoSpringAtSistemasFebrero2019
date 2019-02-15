package com.curso.spring.concesionario;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import feign.RequestInterceptor;

@Configuration
@EnableOAuth2Client
public class ConfiguracionOauth {

	private static final Logger log = LoggerFactory.getLogger(ConfiguracionOauth.class);

    @Value("${config.oauth2.accessTokenUri}")
    private String accessTokenUri;

    @Value("${config.oauth2.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${config.oauth2.clientID}")
    private String clientID;

    @Value("${config.oauth2.clientSecret}")
    private String clientSecret;

	
    /*@Bean
    public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resource(), oauth2ClientContext);
    }*/
    
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext) {
       return new OAuth2FeignRequestInterceptor(oauth2ClientContext, resource());
    }

    private OAuth2ProtectedResourceDetails resource() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId(clientID);
        resource.setClientSecret(clientSecret);
        resource.setAccessTokenUri(accessTokenUri);
        resource.setUserAuthorizationUri(userAuthorizationUri);
        resource.setScope(Arrays.asList("read","write"));

        return resource;
    }
	
}
