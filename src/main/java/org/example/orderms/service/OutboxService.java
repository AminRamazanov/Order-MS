package org.example.orderms.service;

import org.example.orderms.dao.OutboxEvent;

public interface OutboxService {
    void processSingleEvent(OutboxEvent event);
}
