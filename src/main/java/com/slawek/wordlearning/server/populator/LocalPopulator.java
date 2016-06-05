package com.slawek.wordlearning.server.populator;

import com.slawek.wordlearning.server.rest.model.LessonRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@Profile("local")
public class LocalPopulator implements Populator {
	@Value(value = "${web.server}")
	private String address;
	private RestTemplate restTemplate;

	public LocalPopulator() {
		restTemplate = new RestTemplate();
	}

	@Override 
	public void populateToExternalServers(LessonRest lessonRest) {
		URI uri = URI.create(address);
		restTemplate.put(uri, lessonRest);
	}
}
