package proxy.jdk.aop;

import org.junit.Test;

/**
 * Created by jinjunzhu on 2019/9/15.
 */
public class TestAopJDKProxy {
    @Test
    public void testJDKProxy() throws Exception {
        System.out.println("无代理前 调用方法 userService.saveUser 输出......");
        IUserService userService = new UserServiceImpl();
        userService.saveUser("zby", "1234567890");

        System.out.println("有代理后AOP 是怎么样的？ Proxy......");
        IUserService proxyUserService = (IUserService) JDKDynamicProxyGenerator.generatorJDKProxy(userService, new CustomAspect());
        proxyUserService.saveUser("zby", "1234567890");        /** 制造异常,两个入参都是null   */
        proxyUserService.saveUser(null, null);
    }
}
