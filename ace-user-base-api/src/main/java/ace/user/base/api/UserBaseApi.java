package ace.user.base.api;

import ace.fw.restful.base.api.service.AbstractRestfulBaseService;
import ace.user.base.define.constant.UserConstants;
import ace.user.base.define.dao.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@FeignClient(
        name = UserConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "UserBaseApi",
        path = "/" + UserBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface UserBaseApi extends AbstractRestfulBaseService<User> {
    String MODULE_RESTFUL_NAME = "user-base";
}
