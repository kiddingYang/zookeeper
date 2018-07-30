package com.std.list;

import java.util.function.Consumer;

public class FunctionCoding {


    public static void main(String[] args) {


        Consumer<Impl> implConsumer = Impl::uu;
        Impl impl = new Impl();
        implConsumer.accept(impl);
    }


    void TestFunction(MyFunction function) {
        function.invoke();
    }


}


@FunctionalInterface
interface MyFunction {

    void invoke();

}


class Impl implements MyFunction {

    @Override
    public void invoke() {
        System.out.println("invoke............");
    }

    public void uu() {
        System.out.println("a");
    }

}
