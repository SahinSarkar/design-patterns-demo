package com.sahin.sarkar.designpatternsdemo.observer.email.subscriber;

import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.OrderPublisher;

public class ShipmentUpdateEmailService implements EmailNotificationService {

	private int id;

	public ShipmentUpdateEmailService(int id) {
		System.out.println("ShipmentUpdateEmailService with id = " + id);
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void update(OrderPublisher order) {
		System.out.println("Shipped from seller = " + order);
	}
}
