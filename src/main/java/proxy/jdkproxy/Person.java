package proxy.jdkproxy;

/**
 * Created by jinjunzhu on 2019/9/15.
 * java的java.lang.reflect包下提供了Proxy类和一个 InvocationHandler 接口，这个类Proxy定义了生成JDK动态代理类的方法 getProxyClass(ClassLoader loader,Class<?>... interfaces)生成动态代理类,返回class实例代表一个class文件。可以保存该 class 文件查看jdk生成的代理类文件长什么样
 * <p>
 * 该生成的动态代理类继承Proxy类，(重要特性) ，并实现公共接口。
 * <p>
 * InvocationHandler这个接口 是被动态代理类回调的接口，我们所有需要增加的针对委托类的统一处理逻辑都增加到invoke 方法里面在调用委托类接口方法之前或之后 结束战斗。
 */
public interface Person {
    /**
     * @param name 人名
     * @param dst 工作目的地
     */
    void goWorking(String name, String dst);

    /**
     * 获取名称
     * @return
     */
    String getName();

    /**
     * 设置名称
     * @param name
     */
    void setName(String name);
}
