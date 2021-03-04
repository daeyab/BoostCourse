package org.daoPractice.main;

import java.util.List;
import org.daoPractice.config.ApplicationConfig;
import org.daoPractice.dao.RoleDao;
import org.daoPractice.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class queryTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = applicationContext.getBean(RoleDao.class);

        List<Role> list = roleDao.selectAll();
        for(Role role:list)
            System.out.println(role.toString());
    }
}
