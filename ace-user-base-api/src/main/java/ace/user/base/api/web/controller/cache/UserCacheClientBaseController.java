package ace.user.base.api.web.controller.cache;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ace.user.base.api.cache.UserCacheClientBaseApi;
/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */

@RestController
@RequestMapping(path = "/" + UserCacheClientBaseApi.MODULE_RESTFUL_NAME)
@Validated
public interface UserCacheClientBaseController extends UserCacheClientBaseApi {

}
