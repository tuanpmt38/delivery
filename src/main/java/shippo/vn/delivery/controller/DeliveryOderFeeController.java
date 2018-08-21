package shippo.vn.delivery.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import shippo.vn.delivery.model.DeliveryOrderFee;
import shippo.vn.delivery.repository.DeliveryOrderFeeRepository;
import shippo.vn.delivery.service.service.DeliveryOrderFeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class DeliveryOderFeeController {

    @Autowired
    private DeliveryOrderFeeRepository deliveryOrderFeeRepository;

    private static final Logger logger = LogManager.getLogger(DeliveryOrderFee.class);

    private DeliveryOrderFeeService deliveryOrderFeeService;

    public DeliveryOderFeeController(DeliveryOrderFeeService deliveryOrderFeeService) {
        this.deliveryOrderFeeService = deliveryOrderFeeService;
    }

    @RequestMapping(value = "/orderfees", method = RequestMethod.GET)
    public ResponseEntity<List<DeliveryOrderFee>> getOrderFees() {

        List<DeliveryOrderFee> deliveryOrderFees = deliveryOrderFeeService.findAll();
        if (deliveryOrderFees.isEmpty()) {
            return new ResponseEntity<List<DeliveryOrderFee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DeliveryOrderFee>>(deliveryOrderFees, HttpStatus.OK);
    }

//    @RequestMapping(value = "/orderfee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Optional<DeliveryOrderFee> getOrderFeeById(@PathVariable("id") Integer id) {
//
//        logger.info("Fetching DeliveryOrderFee with id {}", id);
//        Optional<DeliveryOrderFee> deliveryOrderFee = deliveryOrderFeeService.findById(id);
//        if (deliveryOrderFee.isPresent()) {
//            DeliveryOrderFee deliveryOrderFees = deliveryOrderFee.get();
//        }
//
//        return deliveryOrderFee;
//    }
    @RequestMapping(value = "/orderfee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryOrderFee> getOrderFeeById(@PathVariable("id") Integer id){

        Optional<DeliveryOrderFee> deliveryOrderFee = deliveryOrderFeeService.findById(id);
        if(deliveryOrderFee.isPresent()){
            return new ResponseEntity<>(deliveryOrderFee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/orderfees", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrderFee(@RequestBody DeliveryOrderFee deliveryOrderFee, UriComponentsBuilder ucBuilder) {

        logger.info("Creating DeliveryOrderFee : {}", deliveryOrderFee);
        deliveryOrderFeeService.save(deliveryOrderFee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/orderfee/{id}").buildAndExpand(deliveryOrderFee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/orderfee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DeliveryOrderFee> deleteOrderFeeId (@PathVariable ("id") Integer id){

        logger.info("Fetching & Deleting Delivery with id {}", id);
        Optional<DeliveryOrderFee> deliveryOrderFee = deliveryOrderFeeService.findById(id);
        if(deliveryOrderFee == null){
            logger.error("Unable to delete. Delivery with id {} not found.", id);
            return new ResponseEntity<DeliveryOrderFee>(HttpStatus.NOT_FOUND);
        }
        if (deliveryOrderFee.isPresent()) {
            DeliveryOrderFee deliveryOrderFees = deliveryOrderFee.get();
            deliveryOrderFeeService.delete(deliveryOrderFees.getId());
        }
        return new ResponseEntity<DeliveryOrderFee>(HttpStatus.NO_CONTENT);
    }



}
