package shippo.vn.delivery.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippo.vn.delivery.model.DeliveryOrderFee;
import shippo.vn.delivery.repository.DeliveryOrderFeeRepository;
import shippo.vn.delivery.service.service.DeliveryOrderFeeService;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryOrderFeeServiceImpl implements DeliveryOrderFeeService {

    private DeliveryOrderFeeRepository deliveryOrderFeeRepository;
    @Autowired
    public DeliveryOrderFeeServiceImpl(DeliveryOrderFeeRepository deliveryOrderFeeRepository){
        this.deliveryOrderFeeRepository = deliveryOrderFeeRepository;
    }

    @Override
    public List<DeliveryOrderFee> findAll() {
        return (List<DeliveryOrderFee>) deliveryOrderFeeRepository.findAll();
    }

    @Override
    public Optional<DeliveryOrderFee> findById(Integer id) {
        return deliveryOrderFeeRepository.findById(id);
    }

    @Override
    public void save(DeliveryOrderFee deliveryOrderFee) {

         deliveryOrderFeeRepository.save(deliveryOrderFee);
    }

    @Override
    public void delete(Integer id) {
         deliveryOrderFeeRepository.deleteById(id);
    }

    @Override
    public DeliveryOrderFee findByName(String name) {
        return deliveryOrderFeeRepository.findByFeeName(name);
    }

    @Override
    public boolean isDeliveryOrderExist(DeliveryOrderFee deliveryOrderFee) {
        return findByName(deliveryOrderFee.getFeeName())!=null;
    }


}
