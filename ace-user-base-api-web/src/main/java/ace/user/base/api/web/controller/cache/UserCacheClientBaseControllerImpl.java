package ace.user.base.api.web.controller.cache;

import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.user.base.api.web.service.cache.UserMultiCacheOrDbService;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.module.user.request.FindByAppIdAndIdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
public class UserCacheClientBaseControllerImpl implements UserCacheClientBaseController {

    @Autowired
    private UserMultiCacheOrDbService userMultiCacheOrDbService;


    @Override
    public GenericResponseExt<User> findByAppIdAndIdFromMultiCacheOrDb(@Valid FindByAppIdAndIdRequest request) {
        User user = userMultiCacheOrDbService.findByAppIdAndIdFromMultiCacheOrDb(request);
        return GenericResponseExtUtils.buildSuccessWithData(user);
    }

    @Override
    public GenericResponseExt<User> findByAppIdAndIdFromMultiCache(@Valid FindByAppIdAndIdRequest request) {
        User user = userMultiCacheOrDbService.findByAppIdAndIdFromMultiCache(request);
        return GenericResponseExtUtils.buildSuccessWithData(user);
    }
}
