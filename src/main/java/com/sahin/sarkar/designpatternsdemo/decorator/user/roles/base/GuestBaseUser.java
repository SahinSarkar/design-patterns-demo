package com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base;

import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.Action;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType.GUEST;

@Data
@AllArgsConstructor
public class GuestBaseUser implements User {

	private int id;

	@Override
	public ArrayList<UserType> getUserTypesDecoratedByCurrentUser() {
		ArrayList<UserType> typesInThisUser = new ArrayList<>();
		typesInThisUser.add(GUEST);
		return typesInThisUser;
	}

	@Override
	public boolean getPermissionTo(Action action) {
		return action == Action.READ_POST ? true : false;
	}
}
