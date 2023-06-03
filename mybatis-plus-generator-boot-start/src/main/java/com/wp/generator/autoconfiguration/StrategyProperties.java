package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.Controller;
import com.baomidou.mybatisplus.generator.config.builder.Entity;
import com.baomidou.mybatisplus.generator.config.builder.Mapper;
import com.baomidou.mybatisplus.generator.config.builder.Service;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;


/**
 * 策略配置接收类
 *
 * @author wp
 * @version 1.0
 */
@ConfigurationProperties("generator.strategy")
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
     * 不配置默认全部表
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
     * 模糊匹配规则(匹配字符串%位置)
     */
    private SqlLike sqlLike;

    /**
     * 模糊匹配规则(like还是notLike)
     */
    private Boolean isLike;

    /**
     * 模糊匹配字符串
     */
    private String likeStr;

    /**
     * 实体策略配置对象
     */
    private EntityStrategyProperties entity;

    /**
     * controller策略配置对象
     */
    private ControllerStrategyProperties controller;

    /**
     * service策略配置对象
     */
    private ServiceStrategyProperties service;

    /**
     * mapper策略配置对象
     */
    private MapperStrategyProperties mapper;

    public StrategyProperties() {
        //设置默认值
        this.sqlLike = SqlLike.DEFAULT;
        this.isLike = true;
    }

    public void setCapitalMode(boolean capitalMode) {
        isCapitalMode = capitalMode;
    }

    public void setSkipView(boolean skipView) {
        this.skipView = skipView;
    }

    public void setTablePrefixes(String tablePrefixes) {
        this.tablePrefixes = tablePrefixes;
    }

    public void setTableSuffixes(String tableSuffixes) {
        this.tableSuffixes = tableSuffixes;
    }

    public void setFieldPrefixes(String fieldPrefixes) {
        this.fieldPrefixes = fieldPrefixes;
    }

    public void setFieldSuffixes(String fieldSuffixes) {
        this.fieldSuffixes = fieldSuffixes;
    }

    public void setIncludeTables(String includeTables) {
        this.includeTables = includeTables;
    }

    public void setExcludeTables(String excludeTables) {
        this.excludeTables = excludeTables;
    }

    public void setEnableSqlFilter(boolean enableSqlFilter) {
        this.enableSqlFilter = enableSqlFilter;
    }

    public void setEnableSchema(boolean enableSchema) {
        this.enableSchema = enableSchema;
    }

    public void setSqlLike(SqlLike sqlLike) {
        this.sqlLike = sqlLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public void setLikeStr(String likeStr) {
        this.likeStr = likeStr;
    }

    public void setEntity(EntityStrategyProperties entity) {
        this.entity = entity;
    }

    public void setController(ControllerStrategyProperties controller) {
        this.controller = controller;
    }

    public void setService(ServiceStrategyProperties service) {
        this.service = service;
    }

    public void setMapper(MapperStrategyProperties mapper) {
        this.mapper = mapper;
    }

    public boolean isCapitalMode() {
        return isCapitalMode;
    }

    public boolean isSkipView() {
        return skipView;
    }

    public String getTablePrefixes() {
        return tablePrefixes;
    }

    public String getTableSuffixes() {
        return tableSuffixes;
    }

    public String getFieldPrefixes() {
        return fieldPrefixes;
    }

    public String getFieldSuffixes() {
        return fieldSuffixes;
    }

    public String getIncludeTables() {
        return includeTables;
    }

    public String getExcludeTables() {
        return excludeTables;
    }

    public boolean isEnableSqlFilter() {
        return enableSqlFilter;
    }

    public boolean isEnableSchema() {
        return enableSchema;
    }

    public SqlLike getSqlLike() {
        return sqlLike;
    }

    public Boolean getLike() {
        return isLike;
    }

    public String getLikeStr() {
        return likeStr;
    }

    public EntityStrategyProperties getEntity() {
        return entity;
    }

    public ControllerStrategyProperties getController() {
        return controller;
    }

    public ServiceStrategyProperties getService() {
        return service;
    }

    public MapperStrategyProperties getMapper() {
        return mapper;
    }

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

        if (this.skipView == Boolean.TRUE) {
            builder.enableSkipView();
        }

        if (this.tablePrefixes != null) {
            List<String> strings = Arrays.
                    stream(this.tablePrefixes.split(",")).toList();
            builder.addTablePrefix(strings);
        }

        if (this.tableSuffixes != null) {
            List<String> strings = Arrays.
                    stream(this.tableSuffixes.split(",")).toList();
            builder.addTableSuffix(strings);
        }

        if (this.fieldPrefixes != null) {
            List<String> strings = Arrays.
                    stream(this.fieldPrefixes.split(",")).toList();
            builder.addTablePrefix(strings);
        }

        if (this.fieldSuffixes != null) {
            List<String> strings = Arrays.
                    stream(this.fieldSuffixes.split(",")).toList();
            builder.addTablePrefix(strings);
        }

        if (this.includeTables != null) {
            builder.addInclude(includeTables);
        }

        if(this.excludeTables != null) {
            List<String> strings = Arrays.
                    stream(excludeTables.split(",")).toList();
            builder.addExclude(strings);
        }

        if (this.enableSqlFilter == Boolean.FALSE) {
            builder.disableSqlFilter();
        }

        if (this.enableSchema == Boolean.TRUE) {
            builder.enableSchema();
        }

        if (this.likeStr != null) {
            if (this.isLike) {
                builder.likeTable(new LikeTable(this.likeStr, this.sqlLike));
            }
            else {
                builder.notLikeTable(new LikeTable(this.likeStr, this.sqlLike));
            }
        }


        //实体策略配置
        Entity.Builder entityBuilder = builder.entityBuilder();
        this.entity.config(entityBuilder);

        //controller策略配置
        Controller.Builder controllerBuilder = builder.controllerBuilder();
        this.controller.config(controllerBuilder);

        //service策略配置
        Service.Builder serviceBuilder = builder.serviceBuilder();
        this.service.config(serviceBuilder);

        //mapper策略配置
        Mapper.Builder mapperBuilder = builder.mapperBuilder();
        this.mapper.config(mapperBuilder);

        return builder;
    }

    /**
     * 实体策略配置类
     */
    public static class EntityStrategyProperties implements IConfigProperties<Entity.Builder> {
        /**
         * 是否生成SerialVersionUID字段
         */
        private Boolean isSerializable;

        /**
         * 是否覆盖生成的文件
         */
        private Boolean fileOverride;

        /**
         * 是否生成字段常量(映射对应表列名，适用于多数据库兼容系统)
         */
        private Boolean columnConstant;

        /**
         * 是否开启链式模型(setter方法返回this)
         */
        private Boolean chainModel;

        /**
         * 是否开启lombok
         */
        private Boolean lombok;

        /**
         * 是否开启 Boolean 类型字段移除 is 前缀
         */
        private Boolean removeIsPrefix;

        /**
         * 是否开启 @TableField 注解
         */
        private Boolean tableFieldAnnotation;

        /**
         * 是否开启 ActiveRecord 模型(将基础CRUD集成到Entity)
         */
        private Boolean activeRecord;

        /**
         * 乐观锁数据库列名
         */
        private String versionColumnName;

        /**
         * 乐观锁实体属性名
         */
        private String versionPropertyName;

        /**
         * 逻辑删除数据库列名
         */
        private String logicDeleteColumnName;

        /**
         * 逻辑删除实体属性名
         */
        private String logicDeletePropertyName;

        /**
         * id生成策略
         */
        private IdType idType;

        /**
         * 格式化文件名称
         */
        private String formatFileName;

        public EntityStrategyProperties() {
            this.isSerializable = false;
            this.fileOverride = true;
            this.lombok = true;
            this.tableFieldAnnotation = true;
            this.formatFileName = "%sPo";
        }

        public Boolean getSerializable() {
            return isSerializable;
        }

        public void setSerializable(Boolean serializable) {
            isSerializable = serializable;
        }

        public Boolean getFileOverride() {
            return fileOverride;
        }

        public void setFileOverride(Boolean fileOverride) {
            this.fileOverride = fileOverride;
        }

        public Boolean getColumnConstant() {
            return columnConstant;
        }

        public void setColumnConstant(Boolean columnConstant) {
            this.columnConstant = columnConstant;
        }

        public Boolean getChainModel() {
            return chainModel;
        }

        public void setChainModel(Boolean chainModel) {
            this.chainModel = chainModel;
        }

        public Boolean getLombok() {
            return lombok;
        }

        public void setLombok(Boolean lombok) {
            this.lombok = lombok;
        }

        public Boolean getRemoveIsPrefix() {
            return removeIsPrefix;
        }

        public void setRemoveIsPrefix(Boolean removeIsPrefix) {
            this.removeIsPrefix = removeIsPrefix;
        }

        public Boolean getTableFieldAnnotation() {
            return tableFieldAnnotation;
        }

        public void setTableFieldAnnotation(Boolean tableFieldAnnotation) {
            this.tableFieldAnnotation = tableFieldAnnotation;
        }

        public Boolean getActiveRecord() {
            return activeRecord;
        }

        public void setActiveRecord(Boolean activeRecord) {
            this.activeRecord = activeRecord;
        }

        public String getVersionColumnName() {
            return versionColumnName;
        }

        public void setVersionColumnName(String versionColumnName) {
            this.versionColumnName = versionColumnName;
        }

        public String getVersionPropertyName() {
            return versionPropertyName;
        }

        public void setVersionPropertyName(String versionPropertyName) {
            this.versionPropertyName = versionPropertyName;
        }

        public String getLogicDeleteColumnName() {
            return logicDeleteColumnName;
        }

        public void setLogicDeleteColumnName(String logicDeleteColumnName) {
            this.logicDeleteColumnName = logicDeleteColumnName;
        }

        public String getLogicDeletePropertyName() {
            return logicDeletePropertyName;
        }

        public void setLogicDeletePropertyName(String logicDeletePropertyName) {
            this.logicDeletePropertyName = logicDeletePropertyName;
        }

        public IdType getIdType() {
            return idType;
        }

        public void setIdType(IdType idType) {
            this.idType = idType;
        }

        public String getFormatFileName() {
            return formatFileName;
        }

        public void setFormatFileName(String formatFileName) {
            this.formatFileName = formatFileName;
        }

        /**
         * 实体策略配置方法
         */
        @Override
        public Entity.Builder config(Entity.Builder builder) {
            if (isSerializable == Boolean.FALSE) {
                builder.disableSerialVersionUID();
            }

            if (this.fileOverride == Boolean.TRUE) {
                builder.enableFileOverride();
            }

            if (this.columnConstant == Boolean.TRUE) {
                builder.enableColumnConstant();
            }

            if (this.chainModel == Boolean.TRUE) {
                builder.enableChainModel();
            }

            if (this.lombok == Boolean.TRUE) {
                builder.enableLombok();
            }

            if (this.removeIsPrefix == Boolean.TRUE) {
                builder.enableRemoveIsPrefix();
            }

            if (this.tableFieldAnnotation == Boolean.TRUE) {
                builder.enableTableFieldAnnotation();
            }

            if (this.activeRecord == Boolean.TRUE) {
                builder.enableActiveRecord();
            }

            if (this.versionColumnName != null) {
                builder.versionColumnName(this.versionColumnName);
            }

            if (this.versionPropertyName != null) {
                builder.versionPropertyName(this.versionPropertyName);
            }

            if (this.idType != null) {
                builder.idType(this.idType);
            }

            if (this.formatFileName != null) {
                builder.formatFileName(this.formatFileName);
            }

            return builder;
        }
    }

    /**
     * controller策略配置类
     */
    public static class ControllerStrategyProperties implements IConfigProperties<Controller.Builder> {

        /**
         * 是否覆盖生成的文件
         */
        private Boolean fileOverride;

        /**
         * 是否开启生成@RestController 控制器
         */
        private Boolean restStyle;

        /**
         * 格式化文件名称
         */
        private String formatFileName;

        public ControllerStrategyProperties() {
            this.fileOverride = true;
            this.restStyle = true;
        }

        public Boolean getFileOverride() {
            return fileOverride;
        }

        public void setFileOverride(Boolean fileOverride) {
            this.fileOverride = fileOverride;
        }

        public Boolean getRestStyle() {
            return restStyle;
        }

        public void setRestStyle(Boolean restStyle) {
            this.restStyle = restStyle;
        }

        public String getFormatFileName() {
            return formatFileName;
        }

        public void setFormatFileName(String formatFileName) {
            this.formatFileName = formatFileName;
        }

        /**
         * controller策略配置方法
         */
        @Override
        public Controller.Builder config(Controller.Builder builder) {

            if (this.fileOverride == Boolean.TRUE) {
                builder.enableFileOverride();
            }

            if (this.restStyle == Boolean.TRUE) {
                builder.enableRestStyle();
            }

            if (this.formatFileName != null) {
                builder.formatFileName(this.formatFileName);
            }

            return builder;
        }
    }

    /**
     * service策略配置类
     */
    public static class ServiceStrategyProperties implements IConfigProperties<Service.Builder> {

        /**
         * 是否覆盖生成的文件
         */
        private Boolean fileOverride;

        /**
         * Service格式化文件名称
         */
        private String formatServiceFileName;

        /**
         * ServiceImpl格式化文件名称
         */
        private String formatServiceImplFileName;

        public ServiceStrategyProperties() {
            this.fileOverride = true;
            this.formatServiceFileName = "%sService";
        }

        public Boolean getFileOverride() {
            return fileOverride;
        }

        public void setFileOverride(Boolean fileOverride) {
            this.fileOverride = fileOverride;
        }

        public String getFormatServiceFileName() {
            return formatServiceFileName;
        }

        public void setFormatServiceFileName(String formatServiceFileName) {
            this.formatServiceFileName = formatServiceFileName;
        }

        public String getFormatServiceImplFileName() {
            return formatServiceImplFileName;
        }

        public void setFormatServiceImplFileName(String formatServiceImplFileName) {
            this.formatServiceImplFileName = formatServiceImplFileName;
        }

        /**
         * service策略配置方法
         */
        @Override
        public Service.Builder config(Service.Builder builder) {

            if (this.fileOverride == Boolean.TRUE) {
                builder.enableFileOverride();
            }

            if (this.formatServiceFileName != null) {
                builder.formatServiceFileName(this.formatServiceFileName);
            }

            if (this.formatServiceImplFileName != null) {
                builder.formatServiceImplFileName(this.formatServiceImplFileName);
            }

            return builder;
        }
    }

    /**
     * mapper策略配置类
     */
    public static class MapperStrategyProperties implements IConfigProperties<Mapper.Builder> {

        /**
         * 是否覆盖生成的文件
         */
        private Boolean fileOverride;

        /**
         * Mapper 注解
         */
        private Class<? extends Annotation> mapperAnnotation;

        /**
         * mapper格式化文件名称
         */
        private String formatMapperFileName;

        /**
         * xml格式化文件名称
         */
        private String formatXmlFileName;

        public MapperStrategyProperties() {
            this.fileOverride = true;
            this.mapperAnnotation = org.apache.ibatis.annotations.Mapper.class;
            this.formatXmlFileName = "%sMapper";
        }

        public Boolean getFileOverride() {
            return fileOverride;
        }

        public void setFileOverride(Boolean fileOverride) {
            this.fileOverride = fileOverride;
        }

        public Class<? extends Annotation> getMapperAnnotation() {
            return mapperAnnotation;
        }

        public void setMapperAnnotation(Class<? extends Annotation> mapperAnnotation) {
            this.mapperAnnotation = mapperAnnotation;
        }

        public String getFormatMapperFileName() {
            return formatMapperFileName;
        }

        public void setFormatMapperFileName(String formatMapperFileName) {
            this.formatMapperFileName = formatMapperFileName;
        }

        public String getFormatXmlFileName() {
            return formatXmlFileName;
        }

        public void setFormatXmlFileName(String formatXmlFileName) {
            this.formatXmlFileName = formatXmlFileName;
        }

        /**
         * mapper策略配置方法
         */
        @Override
        public Mapper.Builder config(Mapper.Builder builder) {

            if (this.fileOverride == Boolean.TRUE) {
                builder.enableFileOverride();
            }

            if (this.mapperAnnotation != null) {
                builder.mapperAnnotation(this.mapperAnnotation);
            }

            return builder;
        }
    }


}
