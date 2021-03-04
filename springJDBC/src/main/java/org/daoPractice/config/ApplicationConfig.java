package org.daoPractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//설정 파일에 다 넣는게 아니라 DB관련 설정을 따로 뺴놓기 위함 (유지보수)

@Configuration
@ComponentScan(basePackages = {"org.daoPractice.dao"})
@Import(DBConfig.class)
public class ApplicationConfig {

}
