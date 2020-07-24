package ace.user.base.define.dao.enums.user;

import ace.fw.enums.BaseEnum;
import ace.fw.util.AceEnumUtils;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 15:58
 * @description 性别
 */
public enum UserSexEnum implements BaseEnum<Integer> {
    UNKNOWN(0, "未知"),

    MALE(1, "男"),

    FEMALE(2, "女");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    UserSexEnum(Integer code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    public static UserSexEnum resolve(Integer eventType) {
        return AceEnumUtils.getEnum(UserSexEnum.class, eventType);
    }
}
