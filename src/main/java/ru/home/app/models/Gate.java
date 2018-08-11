package ru.home.app.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "gates")
public class Gate {
    @Id
    ObjectId id;
    String name;
    private Balance balance;
}
