package ace.user.base.define.dao.entity;

import ace.fw.data.model.entity.Entity;
import ace.user.base.define.dao.enums.user.UserSexEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户基础信息表
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象", description = "用户基础信息表")
public class User implements Serializable, Entity {


    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "appid")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * {@link UserSexEnum}
     */
    @ApiModelProperty(value = "性别,0-未知,1-男,2-女")
    private Integer sex;

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "个人签名")
    private String signature;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "版本号和乐观锁字段,初始为1，更新自增1")
    @Version
    private Integer rowVersion;


    public static final String ID = "id";

    public static final String APP_ID = "app_id";

    public static final String ACCOUNT_ID = "account_id";

    public static final String NICK_NAME = "nick_name";

    public static final String SEX = "sex";

    public static final String AVATAR_URL = "avatar_url";

    public static final String BIRTHDAY = "birthday";

    public static final String SIGNATURE = "signature";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_TIME = "create_time";

    public static final String ROW_VERSION = "row_version";

}
