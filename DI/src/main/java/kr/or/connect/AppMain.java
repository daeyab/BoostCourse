package kr.or.connect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppMain {
    static String CLASS_PATH = "classpath:applicationContext.xml";

    public static void main(String[] args) {
//        DITest();
//        carTest();
//        annotationTest();
//        annotationTest2();
        springUnitTest();

    }

    private static void springUnitTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig3.class);
        CalculatorService calculatorService = applicationContext.getBean(CalculatorService.class);
        System.out.println(calculatorService.plus(20,30));
    }

    private static void annotationTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig1.class);
        Car car = (Car) applicationContext.getBean("car");
        car.run();

        //오타 방지 -> 인자로 넘기는 방법
        Car car2 = applicationContext.getBean(Car.class);
        car2.run();
    }

    private static void annotationTest2() {
       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
       Car car =(Car) applicationContext.getBean("car");
       car.run();
    }

    private static void carTest() {
//        Engine engine = new Engine();
//        Car car = new Car();
//        car.setEngine(engine);
//        car.run();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CLASS_PATH);
        Car car = (Car) applicationContext.getBean("car");
        car.run();
//        DI 의 장점 : 사용자는 사용할 Car 클래스만 알면 됨. 개발자가 관여하는 부분이 적어짐
//        일일히 bean 을 생성하는 방법은 이제 사용하지 않음. Java config & Annotation 으로 활용
    }

    private static void DITest() {
        //어디에서 불러오는지 가져오는 곳
        //ioc : inversion of control
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CLASS_PATH);
        System.out.println("initialized");
        UserBean userBean = (UserBean) applicationContext.getBean("userBean");
        userBean.setAge(27);
        userBean.setName("Kim");
        userBean.setMale(true);
        System.out.println(userBean);

        UserBean userBean1 = (UserBean) applicationContext.getBean("userBean");
        if (userBean == userBean1)
            System.out.println("single-ton");
        System.out.println(userBean1);

    }
}
