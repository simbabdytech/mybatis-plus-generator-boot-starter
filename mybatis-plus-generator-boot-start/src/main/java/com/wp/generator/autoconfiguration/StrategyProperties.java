package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.Controller;
import com.baomidou.mybatisplus.generator.config.builder.Entity;
import com.baomidou.mybatisplus.generator.config.builder.Mapper;
import com.baomidou.mybatisplus.generator.config.builder.Service;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 策略配置接收类
 *
 * @author wp
 * @version 1.0
 */
@ConfigurationProperties("global.strategy")
public class StrategyProperties implements IConfigProperties<StrategyConfig.Builder> {

    /**
     * 是否开启大写命名
     * (应对区分大小写的数据库)
     */
    private boolean isCapitalMode;

    /**
     * 是否跳过视图
     */
    private boolean skipView;

    /**
     * 过滤表前缀(多个以英文逗号(,)隔开)
     */
    private String tablePrefixes;

    /**
     * 过滤表后缀(多个以英文逗号(,)隔开)
     */
    private String tableSuffixes;

    /**
     * 过滤字段前缀(多个以英文逗号(,)隔开)
     */
    private String fieldPrefixes;

    /**
     * 过滤字段前缀(多个以英文逗号(,)隔开)
     */
    private String fieldSuffixes;

    /**
     * 包含表(多个以英文逗号(,)隔开)
     * "all"特指全部表
     */
    private String includeTables;

    /**
     * 排除表(多个以英文逗号(,)隔开)
     */
    private String excludeTables;

    /**
     * 是否开启sql过滤
     * sql过滤是MyBatis防止sql注入的手段
     */
    private boolean enableSqlFilter;

    /**
     * 是否启用schema
     * schema:逻辑层面的数据库(例如一个数据库中几个表一起组成的逻辑整体的一种关系)
     * TODO 未深入了解, 下次深入一下
     */
    private boolean enableSchema;

    /**
     *
     */
    private LikeTable likeTable;
    private LikeTable notLikeTable;

    private EntityStrategyProperties entityStrategy;
    private ControllerStrategyProperties controllerStrategy;
    private ServiceStrategyProperties serviceStrategy;
    private MapperStrategyProperties mapperStrategy;


    /**
     * 策略配置核心方法
     *
     * @param builder 策略配置构建对象
     * @return 配置完成的策略配置构建对象
     */
    @Override
    public StrategyConfig.Builder config(StrategyConfig.Builder builder) {
        //策略配置
        if (this.isCapitalMode == Boolean.TRUE) {
            builder.enableCapitalMode();
        }

        //实体策略配置
        Entity.Builder entityBuilder = builder.entityBuilder();
        this.entityStrategy.config(entityBuilder);

        //controller策略配置
        Controller.Builder controllerBuilder = builder.controllerBuilder();
        this.controllerStrategy.config(controllerBuilder);

        //service策略配置
        Service.Builder serviceBuilder = builder.serviceBuilder();
        this.serviceStrategy.config(serviceBuilder);

        //mapper策略配置
        Mapper.Builder mapperBuilder = builder.mapperBuilder();
        this.mapperStrategy.config(mapperBuilder);

        return builder;
    }

    /**
     * 实体策略配置类
     */
    private static class EntityStrategyProperties implements IConfigProperties<Entity.Builder> {


        /**
         * 实体策略配置方法
         */
        @Override
        public Entity.Builder config(Entity.Builder builder) {
            return builder;
        }
    }

    /**
     * controller策略配置类
     */
    private static class ControllerStrategyProperties implements IConfigProperties<Controller.Builder> {

        /**
         * controller策略配置方法
         */
        @Override
        public Controller.Builder config(Controller.Builder builder) {
            return builder;
        }
    }

    /**
     * service策略配置类
     */
    private static class ServiceStrategyProperties implements IConfigProperties<Service.Builder> {


        /**
         * service策略配置方法
         */
        @Override
        public Service.Builder config(Service.Builder builder) {
            return builder;
        }
    }

    /**
     * mapper策略配置类
     */
    private static class MapperStrategyProperties implements IConfigProperties<Mapper.Builder> {


        /**
         * mapper策略配置方法
         */
        @Override
        public Mapper.Builder config(Mapper.Builder builder) {
            return builder;
        }
    }


}
