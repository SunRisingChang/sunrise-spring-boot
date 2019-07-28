package com.sunrise.core.config.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.cache.annotation.CachePut;

/**
 * 标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中
 * 
 * @author Sun Rising
 * @date 2019.06.30 05:54:55
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
@CachePut(value = "localCache")
public @interface LocalCachePut {

	String key();
}
