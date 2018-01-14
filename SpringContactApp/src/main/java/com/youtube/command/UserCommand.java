package com.youtube.command;

import com.youtube.domain.User;

public class UserCommand {

	User user;
	// More fields if reuired
	// may be there is a case when some fields are not present in database like checkbox, agrreement etc.

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
