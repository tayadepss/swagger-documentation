package addressservice.service;

import java.util.List;

import addressservice.dto.AddressRequest;
import addressservice.dto.AddressResponse;



public interface AddressService {

	List<AddressResponse> getAllAddress();

	AddressResponse addAddress(AddressRequest addressRequest);

	AddressResponse updateAddress(AddressRequest addressRequest, Integer id);

	String deleteAddressById(Integer id);

}
