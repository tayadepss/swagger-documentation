package personservice.service;

import java.util.List;

import personservice.dto.PersonRequest;
import personservice.dto.PersonResponce;

public interface PersonService {

	List<PersonResponce> getAllPerson();

	PersonResponce getPersonById(Integer id);

	PersonResponce addPerson(PersonRequest personRequest);

	PersonResponce updatePerson(PersonRequest personRequest, String name);

	String deletePersonById(Integer id);

}
