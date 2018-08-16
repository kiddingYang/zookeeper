import java.util.ArrayList;
import java.util.List;

public class TestMem {

    private static final int M_1 = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

//        MyList list = new MyList();
        List<byte[]> list = new ArrayList<>();
        for (int i= 0 ;i<25;i++) {
            byte[] malloc = new byte[M_1];
            list.add(malloc);
        }
        Thread.sleep(10000000000L);
    }


//    static class MyList {
//
//        List<byte[]> list = new ArrayList<>();
//
//        public void add(byte[] add){
//            list.add(add);
//        }
//
//    }




}
