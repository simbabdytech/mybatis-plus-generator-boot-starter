package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * starter模块自动配置类
 * 用于初始化FastAutoGenerator Bean对象
 *
 * @author wp
 * @version 1.0
 */
@Configuration
@EnableConfigurationProperties({GlobalProperties.class,
                                PackageProperties.class,
                                TemplateProperties.class,
                                StrategyProperties.class})
@ConditionalOnClass(name = "com.mysql.jdbc.Driver")
public class GeneratorAutoConfiguration {

    private final DataSource dataSource;
    private final GlobalProperties globalProperties;
    private final PackageProperties packageProperties;
    private final TemplateProperties templateProperties;
    private final StrategyProperties strategyProperties;


    public GeneratorAutoConfiguration(DataSource dataSource,
                                      GlobalProperties globalProperties,
                                      PackageProperties packageProperties,
                                      TemplateProperties templateProperties,
                                      StrategyProperties strategyProperties) {
        this.dataSource = dataSource;
        this.globalProperties = globalProperties;
        this.packageProperties = packageProperties;
        this.templateProperties = templateProperties;
        this.strategyProperties = strategyProperties;
    }

    @Bean
    public FastAutoGenerator getFastAutoGenerator() {
        FastAutoGenerator generator;

        //数据源配置
        generator = FastAutoGenerator.create
                        (new DataSourceConfig.Builder(dataSource));

        //全局配置
        generator.globalConfig(builder ->
                globalProperties.config(builder).build());

        //包配置
        generator.packageConfig(builder ->
                packageProperties.config(builder).build());

        //模板配置
        generator.templateConfig(builder ->
                templateProperties.config(builder).build());

        //策略配置
        generator.strategyConfig(builder ->
            strategyProperties.config(builder).build());

        return generator;
    }

}
