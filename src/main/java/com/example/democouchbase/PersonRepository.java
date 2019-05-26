package com.example.democouchbase;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.Optional;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "person")
public interface PersonRepository extends CouchbasePagingAndSortingRepository<Person, String> {

    Optional<Person> findByLastName(String name);
}
