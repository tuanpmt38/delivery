package shippo.vn.delivery.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shippo.vn.delivery.model.MerchantPickupAddress;

@Repository
public interface MerchantPickupAddressRepository extends PagingAndSortingRepository<MerchantPickupAddress, Integer> {

    MerchantPickupAddress findByContactName(String contactName);

    @Query(value = "select * from merchant_pickup_address m where m.is_deleted = true ", nativeQuery = true)
    Page<MerchantPickupAddress> findAll(Pageable pageable);

    @Query(value = "select * from merchant_pickup_address m where m.pickup_contact_name = ?1 " ,nativeQuery = true)
    MerchantPickupAddress findAllByPickupContactNameAndPickupContactPhone(String pickupContactName);
}
