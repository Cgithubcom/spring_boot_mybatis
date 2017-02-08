package com.cone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by pactera on 2017/2/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestT {
    @Value("${other.name}")
    private String name;

    @Test
    public void ttt(){
        System.out.println(name);
    }
}
