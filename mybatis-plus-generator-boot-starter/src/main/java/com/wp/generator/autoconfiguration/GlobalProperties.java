package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.function.Supplier;

/**
 * 全局配置接收类
 *
 * @author wp
 * @version 1.0
 */
@ConfigurationProperties(prefix = "generator.global")
public class GlobalProperties implements IConfigProperties<GlobalConfig.Builder> {
    /**
     * 文件输出路径
     */
    private String outputDir;

    /**
     * 是否打开文件(程序结束时)
     */
    private Boolean openDir;

    /**
     * 作者
     */
    private String author;

    /**
     * 是否打开swagger
     */
    private Boolean swagger;

    /**
     * 时间策略
     * 详细可见TypeRegistry.class
     */
    private DateType dateType;

    /**
     * 日期格式
     */
    private Supplier<String> commentDate;

    public GlobalProperties() {
        //自定义默认值,其他值默认为null即真实默认值以MyBatisPlus官网默认值一致
        this.outputDir = System.getProperty("user.dir") + "/src/main/java";
        this.openDir = false;
        this.author = "wp";
        this.swagger = true;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setOpenDir(Boolean openDir) {
        this.openDir = openDir;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSwagger(Boolean swagger) {
        this.swagger = swagger;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    public void setCommentDate(Supplier<String> commentDate) {
        this.commentDate = commentDate;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public Boolean getOpenDir() {
        return openDir;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getSwagger() {
        return swagger;
    }

    public DateType getDateType() {
        return dateType;
    }

    public Supplier<String> getCommentDate() {
        return commentDate;
    }

    /**
     * 全局配置核心方法
     *
     * @param builder 全局配置构建对象
     * @return 配置完成的全局配置构建对象
     */
    @Override
    public GlobalConfig.Builder config(GlobalConfig.Builder builder) {

        if (this.outputDir != null) {
            builder.outputDir(this.outputDir);
        }

        if (this.openDir == Boolean.FALSE) {
            builder.disableOpenDir();
        }

        if (this.author != null) {
            builder.author(this.author);
        }

        if (this.swagger == Boolean.TRUE) {
            builder.enableSwagger();
        }

        if (this.dateType != null) {
            builder.dateType(this.dateType);
        }

        if(this.commentDate != null) {
            builder.commentDate(this.commentDate);
        }

        return builder;
    }
}
