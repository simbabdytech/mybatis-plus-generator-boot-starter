package com.wp.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * @author wp
 * @version 1.0
 */
@SpringBootApplication
public class GeneratorTestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication
                .run(GeneratorTestApplication.class, args);

        FastAutoGenerator generator = context.getBean(FastAutoGenerator.class);

        generator.execute();

        System.out.println("生成完毕！");

        int exitCode = SpringApplication.exit(context, () -> 0);
        System.exit(exitCode);

    }
}
