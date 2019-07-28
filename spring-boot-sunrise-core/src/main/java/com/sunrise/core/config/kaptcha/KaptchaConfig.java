package com.sunrise.core.config.kaptcha;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

/**
 * kaptcha验证码图片样式配置
 * 
 * @author Sun Rising
 * @date 2019.06.15 06:44:48
 *
 */
@Configuration
public class KaptchaConfig {

	/**
	 * 验证码样式
	 * 
	 * @author Sun Rising
	 * @date 2019.06.13 07:28:24
	 * @return
	 *
	 */
	@Bean
	public DefaultKaptcha kaptchaProducer() {
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties properties = new Properties();
		properties.setProperty("kaptcha.image.width", "125");
		properties.setProperty("kaptcha.image.height", "45");
		// 图片边框，合法值：yes , no
		properties.setProperty("kaptcha.border", "yes");
		// 边框厚度，合法值：>0
		properties.setProperty("kaptcha.border.thickness", "1");
		// 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
		properties.setProperty("kaptcha.border.color", "black");
		// 字体颜色，合法值： r,g,b 或者 white,black,blue.
		properties.setProperty("kaptcha.textproducer.font.color", "blue");
		// 验证码长度
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		// 字体
		properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		// 字体大小
		properties.setProperty("kaptcha.textproducer.font.size", "40");
		// 文字间隔
		properties.setProperty("kaptcha.textproducer.char.space", "2");
		// 干扰颜色，合法值： r,g,b 或者 white,black,blue.
		properties.setProperty("kaptcha.noise.color", "black");
		/**
		 * 图片样式： 水纹com.google.code.kaptcha.impl.WaterRipple
		 * 鱼眼com.google.code.kaptcha.impl.FishEyeGimpy
		 * 阴影com.google.code.kaptcha.impl.ShadowGimpy
		 */
		properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}
}
