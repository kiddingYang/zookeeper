public class testCpu {

    public static void main(String[] args) throws InterruptedException {

        Run thread = new Run("myThread");
        thread.start();
        Thread.sleep(10000000000L);
    }


    static class Run extends Thread {

        int a = 1,b = 1;

        public Run(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                a = add(a,b);
                if(a==1000000) {
                    a = 0;
                }
            }
        }

        public int add(int a,int b) {
            return a+b;
        }
    }

}
