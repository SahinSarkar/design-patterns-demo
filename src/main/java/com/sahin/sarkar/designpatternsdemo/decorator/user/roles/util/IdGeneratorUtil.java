package com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util;

public class IdGeneratorUtil {

	public static int getRandomId() {
		return (int) (Math.random() * 1000);
	}
}
