package addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import addressservice.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
