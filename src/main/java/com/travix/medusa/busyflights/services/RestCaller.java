/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.Exception.RestException;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author temitokut
 */
public class RestCaller <S, T>{
    
     private  String endpoint;
     private  RestTemplate restTemplate;

    public RestCaller(String endpoint, RestTemplate restTemplate) {
        this.endpoint = endpoint;
        this.restTemplate = restTemplate;
    }
    
     public List<T> postRequest(S s, ParameterizedTypeReference typeReference) throws RestException {
        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                new HttpEntity<>(s),
                typeReference
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RestException("There was an unexpected error with the endpoint: " + endpoint + " status code: " + responseEntity.getStatusCode().value());
        }
    }
}
