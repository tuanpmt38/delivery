package shippo.vn.delivery.service.service;


import shippo.vn.delivery.model.DeliveryOrder;

import java.util.Optional;

public interface DeliveryOrderService {

    Optional<DeliveryOrder> findById(Integer id);

    DeliveryOrder findByBarcode(String barcode);

    Iterable<DeliveryOrder> findAll();

}
