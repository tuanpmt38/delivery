package shippo.vn.delivery.services;


import shippo.vn.delivery.model.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    void save(Merchant merchant);

    Optional<Merchant> findById(Integer id);

    List<Merchant> findAll();
}
