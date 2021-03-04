package kr.or.connect;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig1 {
    @Bean
    public Car car(Engine engine) {
        Car c = new Car();
        c.setEngine(engine);
        return c;
    }
    @Bean
    public Engine engine(){
        return new Engine();

    }

}
