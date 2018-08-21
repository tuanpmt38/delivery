package shippo.vn.delivery.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shippo.vn.delivery.model.MerchantPickupAddress;
import shippo.vn.delivery.repository.MerchantPickupAddressRepository;
import shippo.vn.delivery.service.MerchantPickupAddressService;

import java.util.List;
import java.util.Optional;


@Service
public class MerchantPickupAddressServiceImpl implements MerchantPickupAddressService {

    private MerchantPickupAddressRepository merchantPickupAddressRepository;

    @Autowired
    public MerchantPickupAddressServiceImpl(MerchantPickupAddressRepository merchantPickupAddressRepository){
        this.merchantPickupAddressRepository = merchantPickupAddressRepository;
    }
    @Override
    public Page<MerchantPickupAddress> findAll(Pageable pageable) {
        return merchantPickupAddressRepository.findAll(pageable);
    }

    @Override
    public List<MerchantPickupAddress> findAll() {
        return (List<MerchantPickupAddress>) merchantPickupAddressRepository.findAll();
    }

    @Override
    public Optional<MerchantPickupAddress> findById(Integer id) {
        return merchantPickupAddressRepository.findById(id);
    }

    @Override
    public void save(MerchantPickupAddress merchantPickupAddress) {
        merchantPickupAddressRepository.save(merchantPickupAddress);
    }

    @Override
    public void delete(Integer id) {
        merchantPickupAddressRepository.deleteById(id);
    }

    @Override
    public MerchantPickupAddress findAllByPickupContactNameAndPickupContactPhone (String pickupContactName, String pickupContactPhone){
        return merchantPickupAddressRepository.findAllByPickupContactNameAndPickupContactPhone(pickupContactName, pickupContactPhone);
    }

    @Override
    public MerchantPickupAddress findByContactName(String contactName) {
        return merchantPickupAddressRepository.findByContactName(contactName);
    }

    @Override
    public boolean exists(MerchantPickupAddress merchantPickupAddress) {
       return findByContactName(merchantPickupAddress.getContactName()) != null;
    }
}
