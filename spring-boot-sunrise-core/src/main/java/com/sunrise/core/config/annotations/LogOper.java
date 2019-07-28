package com.sunrise.core.config.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 操作日志
 * 
 * @author Sun Rising
 * @date 2019.06.30 06:35:37
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
public @interface LogOper {

	String message();
}
