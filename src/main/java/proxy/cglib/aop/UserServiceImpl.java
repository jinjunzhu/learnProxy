package proxy.cglib.aop;

/**
 * Created by jinjunzhu on 2019/9/15.
 */
public class UserServiceImpl {

    public void saveUser(String username, String password) {
        System.out.println("cglib save user[username=" + username + ",password=" + password + "]");
    }
}
