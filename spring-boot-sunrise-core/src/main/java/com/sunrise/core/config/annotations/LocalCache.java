package com.sunrise.core.config.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.cache.annotation.Cacheable;

/**
 * 可以标记在一个方法上，也可以标记在一个类上。当标记在一个方法上时表示该方法是支持缓存的，
 * 当标记在一个类上时则表示该类所有的方法都是支持缓存的。对于一个支持缓存的方法，Spring会在其被调用后将其返回值缓存起来，
 * 以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法
 * 
 * @author Sun Rising
 * @date 2019.06.30 05:53:22
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Cacheable(value = "localCache")
public @interface LocalCache {

	String key();
}
