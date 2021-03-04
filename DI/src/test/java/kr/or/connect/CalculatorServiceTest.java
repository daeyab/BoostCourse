package kr.or.connect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService;

    @Before
    public void init() {
        this.calculatorService = new CalculatorService();
    }

    @Test
    public void plus() throws Exception{
        int a=5;
        int b=3;

        int result = calculatorService.plus(a,b);
        Assert.assertEquals(8,result);
    }
    @Test
    public void divide() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService. divide (value1, value2);

        // then
        Assert.assertEquals(2,result); // 결과와 2가 같을 경우에만 성공
    }

    @Test
    public void divideExceptionTest() throws Exception{
        // given
        int value1 = 10;
        int value2 = 0;
        try {
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }
        Assert.fail(); // 이부분이 실행되면 무조건 실패다.

    }
}
