package ru.home.app.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.Async;
import ru.home.app.models.User;



public interface UsersRepository extends MongoRepository<User, ObjectId> {
    @Async
    User findByUsername(String username);
}
