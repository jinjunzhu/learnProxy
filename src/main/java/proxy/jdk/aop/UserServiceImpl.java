package proxy.jdk.aop;

/**
 * Created by jinjunzhu on 2019/9/15.
 * 委托类
 */
public class UserServiceImpl implements IUserService{

    @Override
    public void saveUser(String username, String password) throws Exception {
        System.out.println("save user[username=" + username + ",password=" + password + "]");
    }
}
