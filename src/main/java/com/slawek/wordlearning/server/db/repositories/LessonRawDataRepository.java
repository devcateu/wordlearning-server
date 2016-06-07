package com.slawek.wordlearning.server.db.repositories;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.slawek.wordlearning.server.db.model.Lesson;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class LessonRawDataRepository {

	private MongoDatabase db;

	@Value(value = "${spring.data.mongodb.host}")
	private String host;
	@Value(value = "${spring.data.mongodb.port}")
	private int port;
	@Value(value = "${spring.data.mongodb.database}")
	private String database;
	@Value(value = "${spring.data.mongodb.username}")
	private String username;
	@Value(value = "${spring.data.mongodb.password}")
	private String password;

	@Value(value = "${db}")
	private String dbs;

	@PostConstruct
	public void init() {
		MongoClientURI uri = new MongoClientURI(System.getenv("MONGODB_URI"));
		MongoCredential credential = MongoCredential.createCredential(uri.getUsername(), uri.getDatabase(), uri.getPassword());
		MongoClientOptions options = MongoClientOptions.builder().connectTimeout(20).build();
		MongoClient mongoClient = new MongoClient(uri/*new ServerAddress(uri.Po), singletonList(credential), options*/);
		db = mongoClient.getDatabase(uri.getDatabase());
	}

	public List<String> getAllLessonIds() {
		FindIterable<Document> cursor = db.getCollection(Lesson.COLLECTION_NAME)
				.find()
				.projection(Projections.include("_id"));

		ArrayList<String> lessonIds = new ArrayList<>();
		for (Document docu : cursor) {
			lessonIds.add(docu.get("_id").toString());
		}
		return lessonIds;
	}

	public String query(String id) {
		MongoCollection<Document> coll = db.getCollection(Lesson.COLLECTION_NAME);
		FindIterable<Document> documents = coll.find(Filters.eq("_id", new ObjectId(id)));
		List<String> value = new ArrayList<>();

		documents.forEach((Block<Document>) document -> {
			value.add(document.toJson());
		});

		if (value.size() == 1) {
			return value.get(0);
		} else {
			return "kupa";
		}

	}
}
