package proxy.jdk.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
/**
 * Created by jinjunzhu on 2019/9/15.
 * JDK动态代理生成器工具类
 * 可以看到 generatorJDKProxy 方法入参只有两个参数 一个切点接口引用，一个切面接口引用；在InvocationHandler 内部类中可以完整看到切面类方法是怎么影响切点代码执行逻辑的。
 */
public class JDKDynamicProxyGenerator {

    /* @param targetPoint 需要被代理的委托类对象
     * @param aspect 切面对象,该对象方法将在切点方法之前或之后执行
     * @return
             */
    public static Object generatorJDKProxy(IUserService targetPoint, final IAspect aspect) {
        return Proxy.newProxyInstance(                /**
                 *   委托类使用的类加载器
                 */
                targetPoint.getClass().getClassLoader(),
                /**
                 * 委托类实现的接口
                 */
                targetPoint.getClass().getInterfaces(),
                /**
                 * 生成的动态代理类关联的 执行处理器，代理我们的业务逻辑被生成的动态代理类回调
                 * 具体逻辑代码执行,返回值为方法执行结果, 在aop模型中，委托类的接口方法称为切点。
                 */
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {                        // 执行切面方法,对入参进行校验
                        boolean prepareAction = aspect.startTransaction(args);
                        if (prepareAction) {                           // 具体逻辑代码执行,返回值为方法执行结果
                            Object result = method.invoke(targetPoint, args);
                            aspect.endTrasaction();
                            return result;
                        } else {
                            throw new RuntimeException("args: " + Arrays.toString(args) + "不能为null ");
                        }
                    }
                });
    }
}
