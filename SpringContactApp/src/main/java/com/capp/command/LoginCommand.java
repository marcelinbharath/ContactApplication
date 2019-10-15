package com.capp.command;
/**
 * You can some data from Controller to (view) Form and vice versa. example when doing form edit view.
 * Also command is used when data is sent data from view to controller. example while submitting the form to save/update.
 * @author ancilea
 *
 */
public class LoginCommand {
	private String loginName;
	private String password;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
