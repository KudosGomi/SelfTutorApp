package GUI;

import java.util.EventObject;

public class LoginEvent extends EventObject {

//	private String usrPassword;
	private boolean isPasswordCorrect;
	
	public LoginEvent(Object source) {
		super(source);
	}
	
	public LoginEvent(Object source, boolean pass) {
		super(source);
//		this.usrPassword = password;
		this.isPasswordCorrect = pass;
	}

//	public String getUsrPassword() {
//		return usrPassword;
//	}
//
//	public void setUsrPassword(String usrPassword) {
//		this.usrPassword = usrPassword;
//	}

	public boolean getPasswordCorrect() {
		return isPasswordCorrect;
	}

	public void setPasswordCorrect(boolean isPasswordCorrect) {
		this.isPasswordCorrect = isPasswordCorrect;
	}
	
}
