package com.slawek.wordlearning.server.rest;

import com.slawek.wordlearning.server.db.Service;
import com.slawek.wordlearning.server.rest.model.LessonRest;
import com.slawek.wordlearning.server.rest.model.LessonsIdsRest;
import com.slawek.wordlearning.server.rest.model.ServerState;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LessonController {

	private final static Log log = LogFactory.getLog(LessonController.class);

	@Autowired
	private Service service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ServerState state() {
		return ServerState.RUNNING;
	}

	@RequestMapping(path = "/lessons", method = RequestMethod.GET)
	public String getLessons(@RequestParam(value = "id", required = true) String id) {
		log.info("GET lesson: " + id);
		return service.getLesson(id);
	}

	@RequestMapping(path = "/lessons", method = RequestMethod.DELETE)
	public void removeLesson(@RequestParam(value = "id", required = true) String id) {
		service.delete(id);
	}

	@RequestMapping(path = "/lessons/Ids", method = RequestMethod.GET)
	public LessonsIdsRest getLessonsIds() {
		LessonsIdsRest lessonsIdsRest = new LessonsIdsRest();
		lessonsIdsRest.setIds(service.getAllIds());
		return lessonsIdsRest;
	}

	@RequestMapping(path = "/lessons", method = RequestMethod.PUT)
	public void saveLesson(@RequestBody LessonRest lessonRest) {
		log.info("Save lesson: " + lessonRest.toString());
		service.save(lessonRest);
	}
}
