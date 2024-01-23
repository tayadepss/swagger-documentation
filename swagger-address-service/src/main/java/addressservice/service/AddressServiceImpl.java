package addressservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import addressservice.dto.AddressRequest;
import addressservice.dto.AddressResponse;
import addressservice.model.Address;
import addressservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

	private final ModelMapper modelMapper;
	private final AddressRepository addressRepository;
	@Override
	public List<AddressResponse> getAllAddress() {
		List<AddressResponse> addresses=addressRepository.findAll().stream().map(address->mapToAddressResponse(address)).collect(Collectors.toList());
		log.info("in address service, return all addresses");
		return addresses;
	}

	private AddressResponse mapToAddressResponse(Address person) {
		return modelMapper.map(person, AddressResponse.class);
	}



	@Override
	public AddressResponse addAddress(AddressRequest addressRequest) {
		AddressResponse addressResponse=modelMapper.map(addressRepository.save(modelMapper.map(addressRequest,Address.class)),AddressResponse.class);
		return addressResponse;
	}


	@Override
	public AddressResponse updateAddress(AddressRequest addressRequest, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAddressById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
