package com.std.list;

public class FunctionCoding {


    private MyFunction myFunction;

    public FunctionCoding(MyFunction myFunction) {
        this.myFunction = myFunction;
    }

    public static void main(String[] args) {

//        MyFunction cum = Fun::cum;
        Runnable r = Fun::cum;
        MyFunction cum = Fun::cum;

        FunctionCoding coding = new FunctionCoding(Fun::cum);
//        coding.getMyFunction().invoke("ccc");
    }


//    void TestFunction(MyFunction function) {
//        function.invoke();
//    }


    public MyFunction getMyFunction() {
        return myFunction;
    }

    public void setMyFunction(MyFunction myFunction) {
        this.myFunction = myFunction;
    }
}

//
@FunctionalInterface
interface MyFunction {
    void invoke();
}
