package com.sahin.sarkar.designpatternsdemo.decorator.user.roles;

import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base.GuestBaseUser;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.base.User;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.decorators.*;
import com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.Action;

import static com.sahin.sarkar.designpatternsdemo.decorator.user.roles.util.IdGeneratorUtil.getRandomId;

public class RolesTest {

	public static void main(String[] args) {

		User admin = new AdminPermissionAdd(new GuestBaseUser(getRandomId()));
		System.out.println("admin = " + admin);
		System.out.println("admin.getPermissionTo(Action.READ_POST) = " + admin.getPermissionTo(Action.READ_POST));
		System.out.println("admin.getPermissionTo(Action.CREATE_POST) = " + admin.getPermissionTo(Action.CREATE_POST));
		System.out.println("admin.getPermissionTo(Action.EDIT_POST) = " + admin.getPermissionTo(Action.EDIT_POST));
		System.out.println("admin.getPermissionTo(Action.DELETE_POST) = " + admin.getPermissionTo(Action.DELETE_POST));
		System.out.println("admin.getPermissionTo(Action.MANAGE_ROLES) = " + admin.getPermissionTo(Action.MANAGE_ROLES));

		User moderator = new ModeratorPermissionAdd(new GuestBaseUser(getRandomId()));
		System.out.println("moderator = " + moderator);
		System.out.println("moderator.getPermissionTo(Action.READ_POST) = " + moderator.getPermissionTo(Action.READ_POST));
		System.out.println("moderator.getPermissionTo(Action.CREATE_POST) = " + moderator.getPermissionTo(Action.CREATE_POST));
		System.out.println("moderator.getPermissionTo(Action.EDIT_POST) = " + moderator.getPermissionTo(Action.EDIT_POST));
		System.out.println("moderator.getPermissionTo(Action.DELETE_POST) = " + moderator.getPermissionTo(Action.DELETE_POST));
		System.out.println("moderator.getPermissionTo(Action.MANAGE_ROLES) = " + moderator.getPermissionTo(Action.MANAGE_ROLES));

		User member = new MemberPermissionAdd(new GuestBaseUser(getRandomId()));
		System.out.println("member = " + member);
		System.out.println("member.getPermissionTo(Action.READ_POST) = " + member.getPermissionTo(Action.READ_POST));
		System.out.println("member.getPermissionTo(Action.CREATE_POST) = " + member.getPermissionTo(Action.CREATE_POST));
		System.out.println("member.getPermissionTo(Action.EDIT_POST) = " + member.getPermissionTo(Action.EDIT_POST));
		System.out.println("member.getPermissionTo(Action.DELETE_POST) = " + member.getPermissionTo(Action.DELETE_POST));
		System.out.println("member.getPermissionTo(Action.MANAGE_ROLES) = " + member.getPermissionTo(Action.MANAGE_ROLES));


		User guest = new GuestBaseUser(getRandomId());
		System.out.println("guest = " + guest);
		System.out.println("guest.getPermissionTo(Action.READ_POST) = " + guest.getPermissionTo(Action.READ_POST));
		System.out.println("guest.getPermissionTo(Action.CREATE_POST) = " + guest.getPermissionTo(Action.CREATE_POST));
		System.out.println("guest.getPermissionTo(Action.EDIT_POST) = " + guest.getPermissionTo(Action.EDIT_POST));
		System.out.println("guest.getPermissionTo(Action.DELETE_POST) = " + guest.getPermissionTo(Action.DELETE_POST));
		System.out.println("guest.getPermissionTo(Action.MANAGE_ROLES) = " + guest.getPermissionTo(Action.MANAGE_ROLES));

		printRolesForUser(admin);
		printRolesForUser(moderator);
		printRolesForUser(member);
		printRolesForUser(guest);

		System.out.println("Removing permissions now");
		System.out.println("-------------------------");

		admin = new AdminPermissionRemove(admin);

		moderator = new ModeratorPermissionRemove(moderator);

		member = new MemberPermissionRemove(member);

		printRolesForUser(admin);
		printRolesForUser(moderator);
		printRolesForUser(member);
		printRolesForUser(guest);

		// TODO: add test to determine for a user the types it is playing the roles of
	}

	private static void printRolesForUser(User user) {
		System.out.println("User " + user.getId() + " has the following roles:");
		for(Action action: Action.values()) {
			if(user.getPermissionTo(action)) {
				System.out.println("role = " + action);
			}
		}
		System.out.println("-------------------");
	}
}
