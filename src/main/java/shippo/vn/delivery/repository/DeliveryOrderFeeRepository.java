package shippo.vn.delivery.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shippo.vn.delivery.model.DeliveryOrderFee;

@Repository
public interface DeliveryOrderFeeRepository extends PagingAndSortingRepository<DeliveryOrderFee, Integer> {

    DeliveryOrderFee findByFeeName(String name);
}
