package proxy.cglib.aop;

/**
 * Created by jinjunzhu on 2019/9/15.
 */
public interface IAspect {
    /**
     * 在切点接口方法执行之前执行
     */
    void startTransaction();    /**
     * 在切点接口方法执行之后执行
     */
    void endTrasaction();
}
