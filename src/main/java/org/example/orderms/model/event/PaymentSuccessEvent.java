package org.example.orderms.model.event;

public class PaymentSuccessEvent extends BaseEvent {

    private Long orderId;

    public PaymentSuccessEvent() {}

    public PaymentSuccessEvent(Long orderId) {
        this.orderId = orderId;
        setAggregateId(orderId);
    }

    public Long getOrderId() {
        return orderId;
    }
}