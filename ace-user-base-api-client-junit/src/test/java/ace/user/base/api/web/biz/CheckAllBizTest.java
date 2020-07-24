package ace.user.base.api.web.biz;

import ace.user.base.api.UserBaseApi;
import ace.user.base.api.client.application.ClientJUnitBaseApplication;
import ace.fw.json.JsonUtils;
import ace.fw.util.AceLocalDateTimeUtils;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.dao.enums.user.UserSexEnum;
import com.fasterxml.uuid.Generators;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 14:32
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientJUnitBaseApplication.class)
public class CheckAllBizTest {

    private final static String TEST_MOBILE = "15099975787";
    @Autowired
    private UserBaseApi userBaseApi;


    @Test
    public void testAllBiz() {
        User user = this.addUser();
        log.info("addUser success");
    }

    private User addUser() {
        User user = User.builder()
                .accountId(Generators.timeBasedGenerator().generate().toString())
                .appId(Generators.timeBasedGenerator().generate().toString())
                .avatarUrl("")
                .birthday(AceLocalDateTimeUtils.MIN_MYSQL)
                .createTime(LocalDateTime.now())
                .id(Generators.timeBasedGenerator().generate().toString())
                .nickName("nickName")
                .rowVersion(1)
                .sex(UserSexEnum.UNKNOWN.getCode())
                .signature("signature")
                .updateTime(LocalDateTime.now())
                .build();

        userBaseApi.save(user);
        return user;
    }
}
