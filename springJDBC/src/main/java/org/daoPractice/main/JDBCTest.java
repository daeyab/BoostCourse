package org.daoPractice.main;

import org.daoPractice.config.ApplicationConfig;
import org.daoPractice.dao.RoleDao;
import org.daoPractice.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = applicationContext.getBean(RoleDao.class);

//        Role role = new Role();
//        role.setRoleId(1234);
//        role.setDescription("CTO");

//        int result = roleDao.insert(role);
//        System.out.println(result+"건 추가하였습니다.");

        Role role = new Role();
        role.setRoleId(1234);
        role.setDescription("Cook");


        int result = roleDao.update(role);
        System.out.println(result+"건 수정하였습니다.");

        Role r=roleDao.selectById(1234);
        System.out.println(r);

        int result2 = roleDao.deleteById(1234);
        System.out.println(result2+"건 삭제하였습니다.");

    }
}
