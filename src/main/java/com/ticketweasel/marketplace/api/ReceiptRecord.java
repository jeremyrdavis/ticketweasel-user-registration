package com.ticketweasel.marketplace.api;

import com.ticketweasel.users.TicketRecord;

public record ReceiptRecord(TicketRecord ticketRecord, Double price) {
}
