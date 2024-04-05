package com.sahin.sarkar.designpatternsdemo.observer.email.subscriber;

import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.OrderPublisher;

public interface EmailNotificationService {

	int getId();

	void update(OrderPublisher order);

	default boolean equals(EmailNotificationService otherService) {
		return getId() == otherService.getId();
	}

	default String printOrderDetails(OrderPublisher order) {
		return order.toString();
	}
}
