package ace.user.base.api.web.service.cache.impl;

import ace.user.base.api.web.service.cache.UserMultiCacheOrDbService;
import ace.user.base.api.web.dao.UserDbService;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.module.user.request.FindByAppIdAndIdRequest;
import com.alicp.jetcache.anno.Cached;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/30 11:39
 * @description
 */
@Component
@Slf4j
public class UserMultiCacheOrDbServiceImpl implements UserMultiCacheOrDbService {

    private final static String CACHE_NAME = "ace:user:";
    private final static String CACHE_KEY = "args[0].appId + ':' + args[0].id";
    private final static int CACHE_LOCAL_EXPIRE = 60;
    private final static int CACHE_EXPIRE = 5 * 60;

    @Autowired
    private UserDbService userDbService;

    @Cached(name = CACHE_NAME, key = CACHE_KEY, localExpire = CACHE_LOCAL_EXPIRE, expire = CACHE_EXPIRE)
    @Override
    public User findByAppIdAndIdFromMultiCacheOrDb(FindByAppIdAndIdRequest request) {
        User user = userDbService.lambdaQuery()
                .eq(User::getAppId, request.getAppId())
                .eq(User::getId, request.getId())
                .one();

        return user;
    }

    @Cached(name = CACHE_NAME, key = CACHE_KEY, localExpire = CACHE_LOCAL_EXPIRE, expire = CACHE_EXPIRE)
    @Override
    public User findByAppIdAndIdFromMultiCache(FindByAppIdAndIdRequest request) {
        return null;
    }
}
