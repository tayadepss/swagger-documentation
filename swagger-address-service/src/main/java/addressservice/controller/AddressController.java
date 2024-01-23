package addressservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import addressservice.dto.AddressRequest;
import addressservice.dto.AddressResponse;
import addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/address")
@Slf4j
@RequiredArgsConstructor
public class AddressController {
	
	private final AddressService addressService;
	
	@GetMapping("/getAllAddress")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<AddressResponse>> getAllAddress(){
		List<AddressResponse> addressResponse=addressService.getAllAddress();
		log.info("in address controller, return all address");
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
		
	}
	
	
	@PostMapping("/addAddress")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addAddress(@RequestBody AddressRequest addressRequest){
		addressService.addAddress(addressRequest);
		log.info("address added successfully");
		return ResponseEntity.status(HttpStatus.OK).body("address added successfully");
	}
	

	
}
