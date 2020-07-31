package ace.user.base.api.web.service.cache;

import ace.user.base.define.dao.entity.User;
import ace.user.base.define.module.user.request.FindByAppIdAndIdRequest;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/30 11:39
 * @description User对象多级缓存服务
 */
public interface UserMultiCacheOrDbService {
    User findByAppIdAndIdFromMultiCacheOrDb(FindByAppIdAndIdRequest request);

    User findByAppIdAndIdFromMultiCache(FindByAppIdAndIdRequest request);
}
