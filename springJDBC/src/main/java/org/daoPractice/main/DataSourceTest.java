package org.daoPractice.main;

import org.daoPractice.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        Connection connection = null;
        try{
            connection=dataSource.getConnection();
            if(connection!=null)
                System.out.println("SUCCESS");
            else
                System.out.println("FAILED");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection!=null) {
                try {
                    //닫아주기
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }

}
