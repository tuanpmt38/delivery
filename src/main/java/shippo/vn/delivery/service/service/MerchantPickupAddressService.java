package shippo.vn.delivery.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shippo.vn.delivery.model.MerchantPickupAddress;

import java.util.List;
import java.util.Optional;

public interface MerchantPickupAddressService {

Page<MerchantPickupAddress> findAll(Pageable pageable);

List<MerchantPickupAddress> findAll();

Optional<MerchantPickupAddress> findById(Integer id);

void save(MerchantPickupAddress merchantPickupAddress);

void delete(Integer id);

MerchantPickupAddress findByContactName(String contactName);


boolean exists(MerchantPickupAddress merchantPickupAddress) ;

MerchantPickupAddress findAllByPickupContactNameAndPickupContactPhone(String pickupContactName, String pickupContactPhone);

}
