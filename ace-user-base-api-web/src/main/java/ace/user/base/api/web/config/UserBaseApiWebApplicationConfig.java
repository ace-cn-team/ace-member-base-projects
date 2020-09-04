package ace.user.base.api.web.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 15:57
 * @description
 */
@Configuration
@EnableMethodCache(basePackages = {"ace.user.base.api.web.service.cache"})
@EnableCreateCacheAnnotation
@MapperScan("ace.user.base.api.web.dal.mapper")
public class UserBaseApiWebApplicationConfig {

}
