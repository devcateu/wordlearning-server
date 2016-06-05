package com.slawek.wordlearning.server.populator;

import com.slawek.wordlearning.server.rest.model.LessonRest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("server")
public class ServerPopulator implements Populator {
	@Override 
	public void populateToExternalServers(LessonRest lessonRest) {
		
	}
}
