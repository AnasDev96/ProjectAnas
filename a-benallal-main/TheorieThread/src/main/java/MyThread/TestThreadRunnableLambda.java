package MyThread;

//import java.lang.Object;

/**
 *
 * @author g53203
 */
public class TestThreadRunnableLambda {

    public static void main(String[] args) {
        // String name = "lambda_";
        new Thread(() 
            -> {
                for (int i = 0; i < 10; ++i) {
                    for (int j = 0; j < 50000; ++j) ;
                        System.out.println("MyThread: lambda: " + i);
                        // System.out.println("MyThread: " + name + ": " + i);
                    }
        }).start();

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 50000; ++j) ;
            System.out.println("TestMyThread: " + i);
        }
    }
}
