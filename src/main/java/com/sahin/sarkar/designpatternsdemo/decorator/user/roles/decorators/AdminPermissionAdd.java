package com.sahin.sarkar.designpatternsdemo.decorator.user.roles.decorators;

import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base.User;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.Action;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType.ADMIN;

@Data
@AllArgsConstructor
public class AdminPermissionAdd implements User {

	private User decoratedUser;

	@Override
	public ArrayList<UserType> getUserTypesDecoratedByCurrentUser() {

		ArrayList<UserType> userTypesDecoratedByCurrentUser = decoratedUser.getUserTypesDecoratedByCurrentUser();
		if(!userTypesDecoratedByCurrentUser.contains(ADMIN)) {
			userTypesDecoratedByCurrentUser.add(ADMIN);
		}
		return userTypesDecoratedByCurrentUser;
	}

	@Override
	public int getId() {
		return decoratedUser.getId();
	}

	@Override
	public boolean getPermissionTo(Action action) {
		return action == Action.MANAGE_ROLES ? true : decoratedUser.getPermissionTo(action);
	}
}
