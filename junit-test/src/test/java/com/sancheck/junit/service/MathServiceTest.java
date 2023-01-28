package com.sancheck.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: fengyuxiang
 * @ClassName: MathServiceTest
 * @version: 1.0
 * @description:
 * @create: 28/1/2023
 */
public class MathServiceTest {
    @Test
    public void testSum(){
        MathService mathService = new MathService();

        // getting actual value
        int actual = mathService.sum(1,2);

        // getting expected value
        int expected = 3;

        // add assert to test sum method
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSub(){
        MathService mathService = new MathService();

        // getting actual value
        int actual = mathService.sub(10,5);

        // getting expected value
        int expected = 5;

        // add assert to test sum method
        Assert.assertEquals(expected,actual);
    }


}
