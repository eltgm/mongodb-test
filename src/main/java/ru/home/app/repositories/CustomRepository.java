package ru.home.app.repositories;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.home.app.models.Gate;

import javax.money.MonetaryAmount;

@Repository
public class CustomRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Async
    public void sub() {
        Query query = new Query(Criteria.where("_id").is(new ObjectId("5b1846d71b9f6b324ca6b475")).and("balance.amount").gte(15));
        Update update = new Update();
        update.inc("balance.amount", -15);

        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Gate.class);
        System.out.println(result.toString());
    }

    @Async
    public void out(MonetaryAmount amount) {

    }
}
