

import java.io.IOException;

public class LoginMethod {
    private static LoginMethod instance;
    String user="erwin";
    String password="compi2";
    public static LoginMethod getInstance() {
        if(instance == null) {
            instance = new LoginMethod();
        }
        return instance;
    }

    public boolean loginAuthentication(String user_parameter, String password_parameter) throws IOException {
        if(user.equals(user_parameter) && password.equals(password_parameter)) {
            return true;
        }else{
            return false;
        }
    }
}

