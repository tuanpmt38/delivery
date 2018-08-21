package shippo.vn.delivery.service.service;

import shippo.vn.delivery.model.TransactionHistory;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionHistoriesService {

    List<TransactionHistory> findAll();

    List<TransactionHistory> findByBarcode(String barcode);

    List<TransactionHistory> findByAllCreatedAtBetween(Timestamp createAt);

    List<TransactionHistory> findAllByTransType(String transType);

    List<TransactionHistory> findByBarcodeAndTransType(String barcode, String transType);


}
