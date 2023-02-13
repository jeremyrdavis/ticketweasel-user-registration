package com.ticketweasel.marketplace;

import com.ticketweasel.marketplace.api.MarketplaceService;
import com.ticketweasel.marketplace.api.PurchaseRequest;
import com.ticketweasel.marketplace.api.ReceiptRecord;

public class MarketplaceServiceImpl implements MarketplaceService {

    @Override
    public ReceiptRecord buyTickets(PurchaseRequest purchaseRequest) {
        ReceiptRecord receiptRecord = new ReceiptRecord(purchaseRequest.ticketRecord(), purchaseRequest.price());
        return receiptRecord;
    }
}
