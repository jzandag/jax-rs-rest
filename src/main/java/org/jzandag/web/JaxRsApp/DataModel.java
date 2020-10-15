package org.jzandag.web.JaxRsApp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jzandag.web.JaxRsApp.model.User;

public class DataModel {
	
	private Map<Long, User> users = new HashMap<Long, User>();

	public Map<Long, User> getUsers() {
		return users;
	}

	public void setUsers(Map<Long, User> users) {
		this.users = users;
	}
}
