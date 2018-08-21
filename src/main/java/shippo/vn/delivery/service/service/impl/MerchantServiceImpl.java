package shippo.vn.delivery.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippo.vn.delivery.model.Merchant;
import shippo.vn.delivery.repository.MerchantRepository;
import shippo.vn.delivery.service.service.MerchantService;

import java.util.List;
import java.util.Optional;


@Service
public class MerchantServiceImpl implements MerchantService {

    private MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository){
        this.merchantRepository = merchantRepository;
    }
    @Override
    public void save(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    @Override
    public Optional<Merchant> findById(Integer id) {
        return merchantRepository.findById(id);
    }

    @Override
    public List<Merchant> findAll() {
        return (List<Merchant>) merchantRepository.findAll();
    }
}
