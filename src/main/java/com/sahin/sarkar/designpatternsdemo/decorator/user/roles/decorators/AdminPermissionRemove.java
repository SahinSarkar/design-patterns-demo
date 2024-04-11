package com.sahin.sarkar.designpatternsdemo.decorator.user.roles.decorators;

import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base.User;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.Action;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType.ADMIN;
import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType.MEMBER;

@Data
@AllArgsConstructor
public class AdminPermissionRemove implements User {

	private User decoratedUser;

	@Override
	public int getId() {
		return decoratedUser.getId();
	}

	@Override
	public ArrayList<UserType> getUserTypesDecoratedByCurrentUser() {
		ArrayList<UserType> userTypesDecoratedByCurrentUser = decoratedUser.getUserTypesDecoratedByCurrentUser();
		if(userTypesDecoratedByCurrentUser.contains(ADMIN)) {
			userTypesDecoratedByCurrentUser.removeIf(type -> type == ADMIN);
		}
		return userTypesDecoratedByCurrentUser;
	}

	@Override
	public boolean getPermissionTo(Action action) {
		return action == Action.MANAGE_ROLES ? false : decoratedUser.getPermissionTo(action);
	}
}