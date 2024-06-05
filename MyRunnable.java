package Lambda;

public class MyRunnable implements java.lang.Runnable {

    @Override
    public void run()
    {
        System.out.println("Running..");
    }
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread( runnable);
        thread.start();


        java.lang.Runnable myRunnable = () -> System.out.println("New Runnable Object");

        java.lang.Runnable runn = new java.lang.Runnable() {
            @Override
            public void run()
            {
                System.out.println("new Run");
            }
        };

        Thread thread_ = new Thread(runn);
        thread_.start();

        thread_ = new Thread(myRunnable);
        thread_.start();


    }
    
}
