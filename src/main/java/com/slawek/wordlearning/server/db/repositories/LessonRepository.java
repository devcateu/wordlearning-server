package com.slawek.wordlearning.server.db.repositories;

import com.slawek.wordlearning.server.db.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LessonRepository extends MongoRepository<Lesson, String> {
}
