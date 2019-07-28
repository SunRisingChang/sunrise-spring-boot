package com.sunrise.core.config.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.cache.annotation.CacheEvict;

/**
 * 用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。
 * 
 * @author Sun Rising
 * @date 2019.06.30 05:54:19
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
@CacheEvict(value = "localCache")
public @interface LocalCacheEvict {

	String key();
}
