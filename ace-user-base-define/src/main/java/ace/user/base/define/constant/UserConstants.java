package ace.user.base.define.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/4 20:15
 * @description
 */
public interface UserConstants {
    /**
     * base api layer openfeign微服务配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-user-base-api.name:ace-user-base-api-web}";
    /**
     * base api layer openfeign微服务配置包路径
     */
    String BASE_FEIGN_CLIENT_SERVICE_PACKAGE = "ace.user.base.api";
    /**
     * base api layer openfeign微服务自动配置
     */
    String CONFIG_KEY_BASE_API_CLIENT_ENABLE = "ace.ms.service.api.ace-user-base-api.enable";
}
