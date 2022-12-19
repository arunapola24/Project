package com.example.takehome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CountriesService {

    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(CountriesService.class);
    public String getCountriesData(String countries) throws Exception{
        logger.info("input data"+countries);
        try{
            countries = countries.replace(",", "\",\"");
            String countriesString = "\""+countries+"\"";

            String query = "{  countries(filter: {code: {in: ["+countriesString+"]}}) {    continent {      continentName:name  otherCountries:countries{code}  }  }}";

            Map map = new HashMap();
            map.put("query", query);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity entity = new HttpEntity(map,headers);
            String response = restTemplate.exchange("https://countries.trevorblades.com/graphql", HttpMethod.POST, entity, String.class).getBody();
            return response;
        }catch(Exception e){
            logger.error(e.getMessage());
            throw e;
        }

    }

}
