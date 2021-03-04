package kr.or.connect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//spring 설정 파일
@Configuration
//특정 패키지 이하에서 컴포넌트 찾기
@ComponentScan(basePackages = {"kr.or.connect"})

public class AppConfig3 {
}
