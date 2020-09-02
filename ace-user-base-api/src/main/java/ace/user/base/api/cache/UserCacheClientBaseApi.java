package ace.user.base.api.cache;

import ace.fw.model.response.GenericResponseExt;
import ace.user.base.define.constant.UserConstants;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.module.user.request.FindByAppIdAndIdRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@FeignClient(
        name = UserConstants.BASE_FEIGN_CLIENT_NAME,
        url = UserConstants.BASE_FEIGN_CLIENT_URL,
        contextId = "UserCacheClientBaseApi",
        path = "/" + UserCacheClientBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface UserCacheClientBaseApi {
    String MODULE_RESTFUL_NAME = "user-cache-client-base";

    @ApiOperation(value = "从多级缓存或数据库中查询记录")
    @RequestMapping(path = "/find-by-appid-and-id-from-multi-cache-or-db", method = RequestMethod.POST)
    GenericResponseExt<User> findByAppIdAndIdFromMultiCacheOrDb(@Valid @RequestBody FindByAppIdAndIdRequest request);

    @ApiOperation(value = "从多级缓存中查询记录")
    @RequestMapping(path = "/find-by-appid-and-id-from-multi-cache", method = RequestMethod.POST)
    GenericResponseExt<User> findByAppIdAndIdFromMultiCache(@Valid @RequestBody FindByAppIdAndIdRequest request);
}