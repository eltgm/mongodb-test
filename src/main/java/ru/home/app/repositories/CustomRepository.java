package ru.home.app.repositories;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import ru.home.app.models.Gate;

@Repository
public class CustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Async
    public void sub() {
        Query query = new Query(Criteria.where("_id").is(new ObjectId("5b1846d71b9f6b324ca6b475")).and("balance.amount").gte(15));
        Update update = new Update();
        update.inc("balance.amount", -15);

        WriteResult result = this.mongoTemplate.updateFirst(query, update, Gate.class);
        System.out.println(result.toString());
    }
}
