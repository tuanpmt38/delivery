package shippo.vn.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shippo.vn.delivery.model.TransactionHistory;
import shippo.vn.delivery.repository.TransactionHistoriesRepository;
import shippo.vn.delivery.service.service.TransactionHistoriesService;

import java.util.List;

@RestController
public class TransactionHistoriesController {

    private TransactionHistoriesService transactionHistoriesService;
    @Autowired
    private TransactionHistoriesRepository transactionHistoriesRepository;

    @Autowired
    public TransactionHistoriesController(TransactionHistoriesService transactionHistoriesService){
        this.transactionHistoriesService = transactionHistoriesService;
    }

    @RequestMapping(value = "/customer_transactions/", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionHistory>> getAllCustomerTransactions(){

        List<TransactionHistory> transactionHistories = transactionHistoriesService.findAll();
        if(transactionHistories.isEmpty()){
            return new ResponseEntity<List<TransactionHistory>>( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TransactionHistory>>(transactionHistories, HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionHistory>> getCustomerTransaction(
            @RequestParam("barcode") String barcode, @RequestParam("transtype") String transType){
        List<TransactionHistory> transactionHistories = transactionHistoriesService.findByBarcodeAndTransType(barcode, transType);
        if(transactionHistories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactionHistories, HttpStatus.OK);
    }
}
