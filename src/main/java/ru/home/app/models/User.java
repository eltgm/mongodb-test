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
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    private Boolean confirmed;
    private String email;
    private String username;
    private String password;
    private String persistentToken;
}
