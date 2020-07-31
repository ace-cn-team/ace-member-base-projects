package ace.user.base.api.web;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/3 15:21
 * @description
 */
@EnableMethodCache(basePackages = {"ace.user.base.api.web.service.cache"})
@EnableCreateCacheAnnotation
@SpringBootApplication
public class UserBaseApiWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserBaseApiWebApplication.class, args);
    }
}
