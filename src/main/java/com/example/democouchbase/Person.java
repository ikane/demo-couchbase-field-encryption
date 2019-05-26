package com.example.democouchbase;

import com.couchbase.client.java.repository.annotation.EncryptedField;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.example.democouchbase.secure.Encrypted;
import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class Person {

    @Id
    private String id;

    @Field
    private String firstName;

    @Encrypted
    @Field
    private String lastName;


}
