package com.sahin.sarkar.designpatternsdemo.decorator.user.roles.decorators;

import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base.User;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.Action;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType.MEMBER;
import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType.MODERATOR;

@Data
@AllArgsConstructor
public class ModeratorPermissionAdd implements User {

	private User decoratedUser;

	@Override
	public int getId() {
		return decoratedUser.getId();
	}

	@Override
	public ArrayList<UserType> getUserTypesDecoratedByCurrentUser() {
		ArrayList<UserType> userTypesDecoratedByCurrentUser = decoratedUser.getUserTypesDecoratedByCurrentUser();
		if(!userTypesDecoratedByCurrentUser.contains(MODERATOR)) {
			userTypesDecoratedByCurrentUser.add(MODERATOR);
		}
		return userTypesDecoratedByCurrentUser;
	}

	@Override
	public boolean getPermissionTo(Action action) {
		return action == Action.EDIT_POST || action == Action.DELETE_POST ?
			true : decoratedUser.getPermissionTo(action);
	}
}
