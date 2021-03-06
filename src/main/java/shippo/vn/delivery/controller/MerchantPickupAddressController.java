package shippo.vn.delivery.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import shippo.vn.delivery.model.DeliveryOrderFee;
import shippo.vn.delivery.model.MerchantPickupAddress;
import shippo.vn.delivery.services.MerchantPickupAddressService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

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
    public ResponseEntity<Map<String, Object>> getAllMerchantPickupAddress(Pageable pageable){

        Page<MerchantPickupAddress> merchantPickupAddress = merchantPickupAddressService.findAll(pageable);
        logger.info("Get all merchant pickup address "+merchantPickupAddress);
        Pageable pageable1 = new PageRequest(0,2) ;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", merchantPickupAddress.getTotalPages());
        map.put("addresses", merchantPickupAddress);
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/pickup_address/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<MerchantPickupAddress> getMerchantPickupAddressById(@PathVariable("id") Integer id)  {

        logger.info("Fetching merchant pickup address with id: "+ id);
        Optional<MerchantPickupAddress> pickupAddress = merchantPickupAddressService.findById(id);
        logger.info("Result pickup address: " + pickupAddress);
        if(pickupAddress.isPresent()){
            return new ResponseEntity<>(pickupAddress.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(pickupAddress.get(), HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/pickup_address", method = RequestMethod.POST)
    public ResponseEntity<MerchantPickupAddress> createMerchantPickupAddress(@RequestBody MerchantPickupAddress merchantPickupAddress, UriComponentsBuilder builder){

        if (merchantPickupAddressService.exists(merchantPickupAddress)){
            logger.info("a MerchantPickupAddress with name " + merchantPickupAddress.getContactName() + " already exists");
            return new ResponseEntity<MerchantPickupAddress>(HttpStatus.CONFLICT);
        }
        merchantPickupAddressService.save(merchantPickupAddress);
        logger.info("Created merchant pickup address : {}", merchantPickupAddress);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/pickup_address/{id}").buildAndExpand(merchantPickupAddress.getId()).toUri());
        return new ResponseEntity<MerchantPickupAddress>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pickup_address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MerchantPickupAddress> updateMerchantPickupAddress(@PathVariable("id") Integer id, @RequestBody MerchantPickupAddress pickupAddress){

        logger.info("Fetching and update pickup address with id = "+id);
        Optional<MerchantPickupAddress> currentMerchantPickupAddress = merchantPickupAddressService.findById(id);
        if(currentMerchantPickupAddress.isPresent()){

            currentMerchantPickupAddress.get().setContactName(pickupAddress.getContactName());
            currentMerchantPickupAddress.get().setContactPhone(pickupAddress.getContactPhone());
            currentMerchantPickupAddress.get().setFullAddress(pickupAddress.getFullAddress());
            merchantPickupAddressService.save(currentMerchantPickupAddress.get());
            logger.info("Result current merchant pickup address:" + currentMerchantPickupAddress);
            return new ResponseEntity<MerchantPickupAddress>(currentMerchantPickupAddress.get(),HttpStatus.OK);
        }
        logger.info("Pickup address with id: "+ id +" not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @RequestMapping(value = "/pickup_address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MerchantPickupAddress> deleteMerchantPickupAddressById(@PathVariable ("id") Integer id){

        Optional<MerchantPickupAddress> merchantPickupAddress = merchantPickupAddressService.findById(id);
        if(merchantPickupAddress.isPresent()){
            merchantPickupAddress.get().setIsDeleted(false);
            merchantPickupAddressService.save(merchantPickupAddress.get());
            logger.info("Fetching and deleted pickup address with id: "+id+" done");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<MerchantPickupAddress>(merchantPickupAddress.get(), HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/pickup_addresss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MerchantPickupAddress> getMerchantPickupAddressByPickupContactName(@RequestParam("pickupContactPhone")String pickupContactPhone) {

        MerchantPickupAddress merchantPickupAddress = merchantPickupAddressService.findByContactPhone(pickupContactPhone );
        logger.info("Merchant pickup address: " + merchantPickupAddress);

        return new ResponseEntity<>(merchantPickupAddress, HttpStatus.OK);
    }


}
