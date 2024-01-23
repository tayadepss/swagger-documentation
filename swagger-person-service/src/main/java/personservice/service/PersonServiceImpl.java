package personservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import personservice.dto.PersonRequest;
import personservice.dto.PersonResponce;
import personservice.module.Person;
import personservice.repository.PersonRepository;
@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

	private final ModelMapper modelMapper;
	private final PersonRepository personRepository;
	@Override
	public List<PersonResponce> getAllPerson() {
		List<PersonResponce> persons=personRepository.findAll().stream().map(person->mapToPersonResponse(person)).collect(Collectors.toList());
		log.info("in person service, return all persons");
		return persons;
	}

	private PersonResponce mapToPersonResponse(Person person) {
		return modelMapper.map(person, PersonResponce.class);
	}

	@Override
	public PersonResponce getPersonById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonResponce addPerson(PersonRequest personRequest) {
		PersonResponce personResponce=modelMapper.map(personRepository.save(modelMapper.map(personRequest,Person.class)),PersonResponce.class);
		return personResponce;
	}

	@Override
	public PersonResponce updatePerson(PersonRequest personRequest, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePersonById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
