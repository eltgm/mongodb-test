package ru.home.app.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "gates")
public class Gate {
    @Id
    ObjectId id;
    String name;
    Balance balance;

    @Override
    public String toString() {
        return this.getId() + " " + this.getName() + " " + this.getBalance().getMonetary();
    }
}
