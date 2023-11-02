package vladproduction.com.app05;

public class MainApp05 {
    public static void main(String[] args) {

        BusinessProcessor businessProcessor = new BusinessProcessorImpl();
        businessProcessor.process("process-1");

        System.out.println("---proxy run-------");
        BusinessProcessor proxy = new BusinessProcessorProxy(businessProcessor);
        proxy.process("process-1");
    }
}
