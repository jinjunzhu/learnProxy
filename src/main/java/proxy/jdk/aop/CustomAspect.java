package proxy.jdk.aop;

/**
 * Created by jinjunzhu on 2019/9/15.
 * 切面类
 */
public class CustomAspect implements IAspect{
    @Override
    public boolean startTransaction(Object... args) {
        return false;
    }

    @Override
    public void endTrasaction() {

    }
}
