package shippo.vn.delivery.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippo.vn.delivery.model.DeliveryOrder;
import shippo.vn.delivery.repository.DeliveryOrderRepository;
import shippo.vn.delivery.service.service.DeliveryOrderService;

import java.util.Optional;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    private DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    public DeliveryOrderServiceImpl(DeliveryOrderRepository deliveryOrderRepository){
        this.deliveryOrderRepository = deliveryOrderRepository;
    }

    @Override
    public Optional<DeliveryOrder> findById(Integer id) {
        return deliveryOrderRepository.findById(id);
    }

    @Override
    public DeliveryOrder findByBarcode(String barcode ) {
        return deliveryOrderRepository.findByBarcode(barcode);
    }

    @Override
    public Iterable<DeliveryOrder> findAll() {
        return deliveryOrderRepository.findAll();
    }
}
