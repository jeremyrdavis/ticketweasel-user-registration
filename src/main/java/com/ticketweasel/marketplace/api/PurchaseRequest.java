package com.ticketweasel.marketplace.api;

import com.ticketweasel.users.TicketRecord;

public record PurchaseRequest(TicketRecord ticketRecord, Double price) {
}
