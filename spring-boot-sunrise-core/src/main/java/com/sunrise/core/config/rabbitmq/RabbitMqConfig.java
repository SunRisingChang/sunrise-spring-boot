package com.sunrise.core.config.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMq配置文件
 * 
 * @author Sun Rising
 * @date 2019.06.09 01:00:35
 *
 */
@Configuration
public class RabbitMqConfig {

	/**
	 * RabbitMQ 的管理操作
	 * 
	 * @author Sun Rising
	 * @date 2019.06.09 02:28:04
	 * @param connectionFactory
	 * @return
	 *
	 */
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	/**
	 * 定义消息转换实例 转化成 JSON 传输 传输实体就可以不用实现序列化
	 * 
	 * @author Sun Rising
	 * @date 2019.06.09 01:03:24
	 * @return
	 *
	 */
	@Bean
	public MessageConverter integrationEventMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
