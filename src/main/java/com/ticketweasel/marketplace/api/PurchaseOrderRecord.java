package com.ticketweasel.marketplace.api;

import com.ticketweasel.users.TicketRecord;

import java.util.Collection;
import java.util.HashMap;

public record PurchaseOrderRecord(Collection<ReceiptRecord> receiptRecords) {
}
