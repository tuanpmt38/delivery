package shippo.vn.delivery.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippo.vn.delivery.model.TransactionHistory;
import shippo.vn.delivery.repository.TransactionHistoriesRepository;
import shippo.vn.delivery.service.service.TransactionHistoriesService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionHistoriesServiceImpl implements TransactionHistoriesService {

    private TransactionHistoriesRepository transactionHistoriesRepository;

    @Autowired
    public TransactionHistoriesServiceImpl(TransactionHistoriesRepository transactionHistoriesRepository){
        this.transactionHistoriesRepository = transactionHistoriesRepository;
    }
    @Override
    public List<TransactionHistory> findAll() {
        return (List<TransactionHistory>) transactionHistoriesRepository.findAll();
    }

    @Override
    public List<TransactionHistory> findByBarcode(String barcode) {
        return transactionHistoriesRepository.findByBarcode(barcode);
    }

    @Override
    public List<TransactionHistory> findByAllCreatedAtBetween(Timestamp createAt) {
        return transactionHistoriesRepository.findAllByCreatedAtBetween(createAt);
    }

    @Override
    public List<TransactionHistory> findAllByTransType(String transType) {
        return transactionHistoriesRepository.findAllByTransType(transType);
    }

    @Override
    public List<TransactionHistory> findByBarcodeAndTransType(String barcode, String transType  ) {
        return transactionHistoriesRepository.findByBarcodeAndTransType(barcode, transType);
    }
}
