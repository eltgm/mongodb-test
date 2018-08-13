package ru.home.app.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.home.app.models.Gate;

public interface GatesRepository extends MongoRepository<Gate, ObjectId> {
}
