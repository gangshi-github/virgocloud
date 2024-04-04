package com.virgo.cloud.config;


import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    /**
     * 1.重试机制 （默认配置不开启重试机制）
     * 2.period 时间间隔（ms）
     * 3.maxPeriod 重试最大时间间隔 (s)
     * 4.httpclient 默认使用JDK原生HttpUrlConnection发送Http请求
     * <p>
     * Retryer.NEVER_RETRY
     */
    @Bean
    public Retryer retryer() {

        return new Retryer.Default(100, 1, 3);
    }

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
