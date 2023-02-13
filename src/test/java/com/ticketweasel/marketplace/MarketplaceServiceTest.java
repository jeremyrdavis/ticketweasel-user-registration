package com.ticketweasel.marketplace;

import com.ticketweasel.marketplace.api.MarketplaceService;
import com.ticketweasel.marketplace.api.PurchaseRequest;
import com.ticketweasel.marketplace.api.ReceiptRecord;
import com.ticketweasel.users.TicketRecord;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarketplaceServiceTest {

    @Test
    public void testBuyTickets() {
        MarketplaceService marketplaceService = new MarketplaceServiceImpl();

        double price = TestUtil.randomTicketPrice();//
        TicketRecord ticketRecord = new TicketRecord(new Random().nextLong());

        PurchaseRequest purchaseRequest = new PurchaseRequest(ticketRecord, price);

        ReceiptRecord receiptRecord = marketplaceService.buyTickets(purchaseRequest);

        assertNotNull(receiptRecord);
        assertEquals(price, receiptRecord.price());
    }
}
