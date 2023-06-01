package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 模板配置接收类
 *
 * @author wp
 * @version 1.0
 */
@ConfigurationProperties("global.template")
public class TemplateProperties implements IConfigProperties<TemplateConfig.Builder> {
    /**
     * 实体模板文件路径
     */
    private String entityPath;

    /**
     * controller模板文件路径
     */
    private String controllerPath;

    /**
     * mapper模板文件路径
     */
    private String mapperPath;

    /**
     * mapper.xml模板文件路径
     */
    private String xmlPath;

    /**
     * service模板文件路径
     */
    private String servicePath;

    /**
     * serviceImpl模板文件路径
     */
    private String serviceImplPath;


    public void setEntityPath(String entityPath) {
        this.entityPath = entityPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    /**
     * 模板配置核心方法
     *
     * @param builder 模板配置构建对象
     * @return 配置完成的模板配置构建对象
     */
    @Override
    public TemplateConfig.Builder config(TemplateConfig.Builder builder) {
        if (this.entityPath != null) {
            if (this.entityPath.equals("null")) {
                builder.disable(TemplateType.ENTITY);
            }
            else {
                builder.entity(this.entityPath);
            }
        }

        if (this.controllerPath != null) {
            if (this.controllerPath.equals("null")) {
                builder.disable(TemplateType.CONTROLLER);
            }
            else {
                builder.controller(this.controllerPath);
            }
        }

        if (this.mapperPath != null) {
            if (this.mapperPath.equals("null")) {
                builder.disable(TemplateType.MAPPER);
            }
            else {
                builder.mapper(this.mapperPath);
            }
        }

        if (this.xmlPath != null) {
            if (this.xmlPath.equals("null")) {
                builder.disable(TemplateType.XML);
            }
            else {
                builder.xml(this.xmlPath);
            }
        }

        if (this.servicePath != null) {
            if (this.servicePath.equals("null")) {
                builder.disable(TemplateType.SERVICE);
            }
            else {
                builder.service(this.servicePath);
            }
        }

        if (this.serviceImplPath != null) {
            //不生成模板文件
            if (this.serviceImplPath.equals("null")) {
                builder.disable(TemplateType.SERVICE_IMPL);
            }
            else {
                builder.serviceImpl(this.serviceImplPath);
            }
        }

        return builder;
    }
}
