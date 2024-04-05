package com.sahin.sarkar.designpatternsdemo.observer.email.publisher;

import com.sahin.sarkar.designpatternsdemo.observer.email.subscriber.EmailNotificationService;

public interface OrderPublisher {

	void registerNotificationService(String name, EmailNotificationService notificationService);

	void deregisterNotificationService(String ensType, int id);

	void notifyEmailServiceObservers();

	int getOrderId();

	int getUserId();

	OrderStatus getOrderStatus();

	void setOrderStatus(OrderStatus orderStatus);

}
