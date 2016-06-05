package com.slawek.wordlearning.server.populator;

import com.slawek.wordlearning.server.rest.model.LessonRest;

public interface Populator {
	void populateToExternalServers(LessonRest lessonRest);
}
