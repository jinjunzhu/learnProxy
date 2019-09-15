package proxy.cglib.aop;

import org.junit.Test;

/**
 * Created by jinjunzhu on 2019/9/15.
 */
public class TestAopCglibKProxy {
    @Test
    public void testCglibProxy() {
        System.out.println("before Proxy......");
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser("zby", "1234567890");
        System.out.println("引入Cglib  Proxy代理库 后......");
        UserServiceImpl proxyUserService = (UserServiceImpl) CglibProxyGenerator.generatorCglibProxy(userService, new CustomAspect());
        proxyUserService.saveUser("zby", "1234567890");
    }
}
