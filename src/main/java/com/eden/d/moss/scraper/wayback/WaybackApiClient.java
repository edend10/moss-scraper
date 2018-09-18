package com.eden.d.moss.scraper.wayback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Optional;

public class WaybackApiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaybackApiClient.class);

    private RestTemplate restTemplate;

    public WaybackApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<WaybackApiResponse> getWaybackResponse(String url) {
        ResponseEntity<WaybackApiResponse> jsonResponse = restTemplate.getForEntity(url, WaybackApiResponse.class);
        if (jsonResponse.getStatusCode() == HttpStatus.OK) {
            return Optional.of(jsonResponse.getBody());
        } else {
            LOGGER.warn("Wayback api http call failed with status {}: {}",
                    jsonResponse.getStatusCode().value(), jsonResponse.getStatusCode().getReasonPhrase());

            return Optional.empty();
        }
    }
}
