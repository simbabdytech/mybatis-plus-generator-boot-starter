package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;

/**
 * 包配置接收类
 *
 * @author wp
 * @version 1.0
 */
@ConfigurationProperties("generator.package")
public class PackageProperties implements IConfigProperties<PackageConfig.Builder> {
    /**
     * 父包
     */
    private String parentPackage;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 实体包名
     */
    private String entityPackage;

    /**
     * service包名
     */
    private String servicePackage;

    /**
     * serviceImpl包名
     */
    private String serviceImplPackage;

    /**
     * mapper包名
     */
    private String mapperPackage;

    /**
     * controller包名
     */
    private String controllerPackage;

    /**
     * mapper.xml文件输出路径
     */
    private String xmlPath;

    public PackageProperties() {
        //自定义默认值,其他值默认为null即真实默认值以MyBatisPlus官网默认值一致
        this.parentPackage = "com.wp";
        this.entityPackage = "domain.po";
        this.xmlPath = System.getProperty("user.dir") + "/src/main/resources"
                + this.parentPackage + "mapper";
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getParentPackage() {
        return parentPackage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    /**
     * 包配置核心方法
     *
     * @param builder 包配置构建对象
     * @return 配置完成的包配置构建对象
     */
    @Override
    public PackageConfig.Builder config(PackageConfig.Builder builder) {
        builder.parent(this.parentPackage);

        if (this.moduleName != null) {
            builder.moduleName(this.moduleName);
        }

        if (this.entityPackage != null) {
            builder.entity(this.entityPackage);
        }

        if (this.mapperPackage != null) {
            builder.mapper(this.mapperPackage);
        }

        if (this.servicePackage != null) {
            builder.service(this.servicePackage);
        }

        if (this.serviceImplPackage != null) {
            builder.serviceImpl(this.serviceImplPackage);
        }

        if (this.controllerPackage != null) {
            builder.controller(this.controllerPackage);
        }

        if (this.xmlPath != null) {
            builder.pathInfo(Collections.singletonMap
                    (OutputFile.xml, this.xmlPath));
        }

        return builder;
    }
}
