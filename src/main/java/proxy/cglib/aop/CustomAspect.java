package proxy.cglib.aop;

/**
 * Created by jinjunzhu on 2019/9/15.
 */
public class CustomAspect implements IAspect {
    @Override
    public void startTransaction() {
        System.out.println("cglib. I get datasource here and start transaction");
    }
    @Override
    public void endTrasaction() {
        System.out.println("cglib I get datasource here and end transaction");
    }
}
