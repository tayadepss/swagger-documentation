package personservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import personservice.dto.PersonRequest;
import personservice.dto.PersonResponce;
import personservice.service.PersonService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/person")
@Slf4j
@RequiredArgsConstructor
public class PersonController {
	
	private final PersonService personService;
	
	@GetMapping("/getAllPersons")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<PersonResponce>> getAllPersons(){
		List<PersonResponce> personResponce=personService.getAllPerson();
		log.info("in person controller, return all persons");
		return ResponseEntity.status(HttpStatus.OK).body(personResponce);
		
	}
	
	@GetMapping("/getPersonById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PersonResponce> getPersonById(@PathVariable Integer id){
		PersonResponce personResponce=personService.getPersonById(id);
		log.info("in controller, person with id {} return",personResponce.getId());
		return ResponseEntity.status(HttpStatus.OK).body(personResponce);
	}
	
	@PostMapping("/addPerson")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addPerson(@RequestBody PersonRequest personRequest){
		PersonResponce personResponce=personService.addPerson(personRequest);
		log.info("in controller, person added successfully");
		return ResponseEntity.status(HttpStatus.OK).body("person with name:"+personResponce.getName()+" added successfully");
	}
	
	@PutMapping("/updatePerson/{name}")
	public ResponseEntity<String> updatePerson(@PathVariable String name, @RequestBody PersonRequest personRequest) {
		PersonResponce personResponce=personService.updatePerson(personRequest,name);
		log.info("in controller, person updated successfully with name:{}",personResponce.getName());		
		return ResponseEntity.status(HttpStatus.OK).body("person with name:"+personResponce.getName()+" updated successfully");
	}
	
	@DeleteMapping("/deletePersonById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deletePersonById(@RequestParam("id") Integer id ){
		String msg=personService.deletePersonById(id);
		log.info("in controller person with id:{} deleted successfully",id);
		return ResponseEntity.status(HttpStatus.OK).body("person with id:"+id+" deleted successfully");
		
	}
	
}
