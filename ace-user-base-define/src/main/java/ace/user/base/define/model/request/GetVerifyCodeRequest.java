package ace.user.base.define.model.request;

import ace.user.base.define.model.VerifyCodeId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 14:53
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVerifyCodeRequest {
    @ApiModelProperty(value = "验证码Id", required = true)
    @NotNull
    @Valid
    private VerifyCodeId verifyCodeId;
}