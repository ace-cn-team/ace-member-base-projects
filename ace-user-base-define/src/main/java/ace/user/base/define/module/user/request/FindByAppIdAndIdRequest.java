package ace.user.base.define.module.user.request;


import ace.common.base.define.model.constraint.AppIdConstraint;
import ace.user.base.define.constraint.UserIdConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/19 18:28
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindByAppIdAndIdRequest {
    @AppIdConstraint
    @ApiModelProperty(value = AppIdConstraint.FIELD_NAME, required = true)
    private String appId;
    @UserIdConstraint
    @ApiModelProperty(value = UserIdConstraint.FIELD_NAME, required = true)
    private String id;
}
