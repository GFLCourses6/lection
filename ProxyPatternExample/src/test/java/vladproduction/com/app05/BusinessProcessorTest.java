package vladproduction.com.app05;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class BusinessProcessorTest {

    @Test
    public void positiveTest(){

        try(ByteArrayOutputStream buff = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(buff)){
            PrintStream old = System.out;
            System.setOut(out);
            BusinessProcessor businessProcessor = new BusinessProcessorImpl();
            businessProcessor.process("param1");
            System.setOut(old);
            byte[] buffArray = buff.toByteArray();
            String actual = new String(buffArray).trim();
//            for(int i = 0; i<actual.length(); i++){
//                char c = actual.charAt(i);
//                System.out.println("c=" + c);
//            }
            assertEquals("BusinessProcessorImpl.process();", actual);

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void positiveProxyTest(){

        try(ByteArrayOutputStream buff = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(buff)){
            PrintStream old = System.out;
            System.setOut(out);
            BusinessProcessor businessProcessor = new BusinessProcessorImpl();
            BusinessProcessor proxy = new BusinessProcessorProxy(businessProcessor);
            proxy.process("process-1");
            System.setOut(old);
            byte[] buffArray = buff.toByteArray();
            String actual = new String(buffArray).trim();
            String[] array = actual.split("\n");
            assertEquals(array.length, 2);
            assertEquals("BusinessProcessorProxy.process(param) = process-1\r", array[0]);
            assertEquals("BusinessProcessorImpl.process();", array[1]);



        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}
