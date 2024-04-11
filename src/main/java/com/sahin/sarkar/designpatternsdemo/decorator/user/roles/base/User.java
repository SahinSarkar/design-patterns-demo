package com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base;

import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.Action;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.UserType;

import java.util.ArrayList;

public interface User {

	ArrayList<UserType> getUserTypesDecoratedByCurrentUser();

	int getId();

	boolean getPermissionTo(Action action);

}
