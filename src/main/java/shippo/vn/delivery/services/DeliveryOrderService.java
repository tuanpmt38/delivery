package shippo.vn.delivery.services;


import shippo.vn.delivery.model.DeliveryOrder;

import java.util.Optional;

public interface DeliveryOrderService {

    Optional<DeliveryOrder> findById(Integer id);

    DeliveryOrder findByBarcode(String barcode);

    Iterable<DeliveryOrder> findAll();

}
