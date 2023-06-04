package com.wp.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wp
 * @version 1.0
 */
@SpringBootApplication
@PropertySource("classpath:test_bean.yml")
public class TestApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(TestApplication.class, args);

        FastAutoGenerator generator = context.
                getBean(FastAutoGenerator.class);

        generator.execute();
    }
}
