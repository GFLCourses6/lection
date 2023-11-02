package vladproduction.com.app05;

public class BusinessProcessorProxy implements BusinessProcessor {

    public BusinessProcessor target;

    public BusinessProcessorProxy(BusinessProcessor target) {
        this.target = target;
    }

    @Override
    public void process(String param) {
        System.out.println("BusinessProcessorProxy.process(param) = " + param);
        target.process(param);

    }
}
