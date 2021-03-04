package kr.or.connect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
//알아서 지정해주는 방식 -> 패키지 경로를 설정해줘야함
public class AppConfig2 {
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
