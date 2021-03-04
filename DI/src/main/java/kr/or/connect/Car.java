package kr.or.connect;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    private Engine v8;

    public Car() {
        System.out.println("Car constructor");
    }

    public void setEngine(Engine e){
        v8=e;
    }
    public void run(){
        System.out.println("Car running");
        v8.excel();
    }
}
