package GUI;

import java.util.EventListener;

public interface LoginListener extends EventListener {
	public void loginAccepted(LoginEvent log);
}
