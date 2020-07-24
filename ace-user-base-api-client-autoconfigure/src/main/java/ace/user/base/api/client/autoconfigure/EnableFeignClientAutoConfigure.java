package ace.user.base.api.client.autoconfigure;

import ace.user.base.api.web.controller.UserBaseController;
import ace.user.base.define.constant.UserConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/5 1:20
 * @description
 */
@ConditionalOnProperty(
        name = UserConstants.CONFIG_KEY_BASE_API_CLIENT_ENABLE,
        havingValue = "true",
        matchIfMissing = true
)
@ConditionalOnMissingBean({UserBaseController.class})
@ConditionalOnBean(annotation = {EnableFeignClients.class})
@EnableFeignClients(basePackages = {UserConstants.BASE_FEIGN_CLIENT_SERVICE_PACKAGE})
@Configuration
public class EnableFeignClientAutoConfigure {

}
