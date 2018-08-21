package shippo.vn.delivery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shippo.vn.delivery.model.Merchant;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Integer> {
}
