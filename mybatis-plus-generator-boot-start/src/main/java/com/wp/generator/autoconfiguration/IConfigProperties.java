package com.wp.generator.autoconfiguration;

import com.baomidou.mybatisplus.generator.config.IConfigBuilder;

/**
 * 配置接收接口
 *
 * @author wp
 * @version 1.0
 */
public interface IConfigProperties <T extends IConfigBuilder> {
    /**
     * 配置构建类的配置方法
     *
     * @param builder 配置构建对象
     * @return 配置完成的配置构建对象
     */
    T config(T builder);
}
