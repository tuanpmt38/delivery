package shippo.vn.delivery.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shippo.vn.delivery.model.DeliveryOrder;
import shippo.vn.delivery.model.DeliveryOrderFee;
import shippo.vn.delivery.service.service.DeliveryOrderService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
public class DeliveryOrderController {

    private static final Logger logger = LogManager.getLogger(DeliveryOrderFee.class);

    private DeliveryOrderService deliveryOrderService;

    @Autowired
    public DeliveryOrderController (DeliveryOrderService deliveryOrderService){
        this.deliveryOrderService = deliveryOrderService;
    }

    @RequestMapping(value = "/delivery_order/tl/{barcode}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, DeliveryOrder>> getDeliveryOrderByBarcode(@PathVariable("barcode") String barcode){

        Map<String, DeliveryOrder> map=new HashMap<>();
        logger.info("Fetching and delivery order with barcode: " + barcode);
        DeliveryOrder deliveryOrder = deliveryOrderService.findByBarcode(barcode);
        if(deliveryOrder.getBarcode().isEmpty()){
            return (ResponseEntity<Map<String, DeliveryOrder>>) ResponseEntity.status(HttpStatus.NOT_FOUND);

        }
        logger.info("delivery order: " + deliveryOrder);
        map.put("result",deliveryOrder);

        return  ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/delivery_order/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Optional<DeliveryOrder>>> getDeliverOrderById(@PathVariable("id") Integer id){

        logger.info("Fetching and result delivery order with " +id);
        Optional<DeliveryOrder> deliveryOrder = deliveryOrderService.findById(id);
        if(!deliveryOrder.isPresent()){
            return new ResponseEntity(deliveryOrder.get(),HttpStatus.NO_CONTENT);
        }
        Map<String, Optional<DeliveryOrder>> map = new HashMap<>();
        map.put("result", deliveryOrder);
        return ResponseEntity.ok(map);
    }
}
