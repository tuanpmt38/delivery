package shippo.vn.delivery.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import shippo.vn.delivery.model.DeliveryOrderFee;
import shippo.vn.delivery.model.MerchantPickupAddress;
import shippo.vn.delivery.service.MerchantPickupAddressService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MerchantPickupAddressController {

    private static final Logger logger = LogManager.getLogger(DeliveryOrderFee.class);
    public static final int IS_DELETED = 1;

    private MerchantPickupAddressService merchantPickupAddressService;

    @Autowired
    public MerchantPickupAddressController(MerchantPickupAddressService merchantPickupAddressService){
        this.merchantPickupAddressService = merchantPickupAddressService;
    }

//    @RequestMapping(value = "/pickup_address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PagedResources<MerchantPickupAddress>> getMerchantPickupAddress(Pageable pageable, PagedResourcesAssembler assembler) {
//
//        Page<MerchantPickupAddress> merchantPickupAddressPage = merchantPickupAddressService.findAll(pageable);
//        logger.info("Page Merchant pickup address: " + merchantPickupAddressPage);
//        PagedResources < MerchantPickupAddress > pickupAddressPagedResources = assembler.toResource(merchantPickupAddressPage,
//                linkTo(MerchantPickupAddressController.class).slash("/pickup_address").withSelfRel());
//
//        return new ResponseEntity < > (assembler.toResource(merchantPickupAddressPage,
//                linkTo(MerchantPickupAddressController.class).slash("/pickup_address").withSelfRel()), HttpStatus.OK);
//
////        return new ResponseEntity<>(merchantPickupAddressPage, HttpStatus.OK);
//    }

    @RequestMapping(value = "/pickup_address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllMerchantPickupAddress(){

        List<MerchantPickupAddress> merchantPickupAddress = merchantPickupAddressService.findAll();
        logger.info("Get all merchant pickup address "+merchantPickupAddress);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", merchantPickupAddress.size());
        map.put("addresses", merchantPickupAddress);
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/pickup_address/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<MerchantPickupAddress> getMerchantPickupAddressById(@PathVariable("id") Integer id)  {

        logger.info("Fetching merchant pickup address with id: "+ id);
        Optional<MerchantPickupAddress> pickupAddress = merchantPickupAddressService.findById(id);
        logger.info("Result pickup address: " + pickupAddress);
        if(!pickupAddress.isPresent()){
            return new ResponseEntity<>(pickupAddress.get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pickupAddress.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/pickup_address", method = RequestMethod.POST)
    public ResponseEntity<Void> createMerchantPickupAddress(@RequestBody MerchantPickupAddress merchantPickupAddress, UriComponentsBuilder builder){

        if (merchantPickupAddressService.exists(merchantPickupAddress)){
            logger.info("a user with name " + merchantPickupAddress.getContactName() + " already exists");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        merchantPickupAddressService.save(merchantPickupAddress);
        logger.info("Created merchant pickup address : {}", merchantPickupAddress);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/pickup_address/{id}").buildAndExpand(merchantPickupAddress.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pickup_address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MerchantPickupAddress> updateMerchantPickupAddress(@PathVariable("id") Integer id, @RequestBody MerchantPickupAddress pickupAddress){

        logger.info("Fetching and update pickup address with id = "+id);
        Optional<MerchantPickupAddress> currentMerchantPickupAddress = merchantPickupAddressService.findById(id);
        if(!currentMerchantPickupAddress.isPresent()){
            logger.info("Pickup address with id: "+ id +" not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentMerchantPickupAddress.get().setContactName(pickupAddress.getContactName());
        currentMerchantPickupAddress.get().setContactPhone(pickupAddress.getContactPhone());
        currentMerchantPickupAddress.get().setFullAddress(pickupAddress.getFullAddress());
        merchantPickupAddressService.save(currentMerchantPickupAddress.get());
        logger.info("Result current merchant pickup address:" + currentMerchantPickupAddress);
        return new ResponseEntity<MerchantPickupAddress>(currentMerchantPickupAddress.get(),HttpStatus.OK);

    }

    @RequestMapping(value = "/pickup_address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MerchantPickupAddress> deleteMerchantPickupAddressById(@PathVariable ("id") Integer id){

        Optional<MerchantPickupAddress> merchantPickupAddress = merchantPickupAddressService.findById(id);
        merchantPickupAddress.get().setIsDeleted(false);
        merchantPickupAddressService.save(merchantPickupAddress.get());
        logger.info("Fetching and deleted pickup address with id: "+id+" done");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/pickup_address/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MerchantPickupAddress> getAllMerchantPickupAddressByPickupContactNameAndPickupContactPhone(@RequestParam("pickupContactName")String pickupContactName, @RequestParam("pickupContactPhone") String pickupContactPhone) {

        MerchantPickupAddress merchantPickupAddress = merchantPickupAddressService.findAllByPickupContactNameAndPickupContactPhone(pickupContactName, pickupContactPhone );
        logger.info("Merchant pickup address: " + merchantPickupAddress);

        return new ResponseEntity<>(merchantPickupAddress, HttpStatus.OK);
    }


}
