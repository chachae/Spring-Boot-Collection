package com.chachae.redis.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author chachae
 * @since 2020/1/11 15:26
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {}
