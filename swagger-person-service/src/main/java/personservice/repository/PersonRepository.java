package personservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import personservice.module.Person;

public interface PersonRepository extends MongoRepository<Person, Integer> {

}
