package ace.user.base.api;

import ace.fw.restful.base.api.AbstractBaseApi;
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
        url = UserConstants.BASE_FEIGN_CLIENT_URL,
        contextId = "UserBaseApi",
        path = "/" + UserBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface UserBaseApi extends AbstractBaseApi<User, String> {
    String MODULE_RESTFUL_NAME = "user-base";
}
