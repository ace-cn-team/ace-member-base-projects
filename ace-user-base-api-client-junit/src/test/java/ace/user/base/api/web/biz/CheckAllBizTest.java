package ace.user.base.api.web.biz;

import ace.user.base.api.UserBaseApi;
import ace.user.base.api.cache.UserCacheClientBaseApi;
import ace.user.base.api.client.application.ClientJUnitBaseApplication;
import ace.fw.util.AceLocalDateTimeUtils;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.dao.enums.user.UserSexEnum;
import ace.user.base.define.module.user.request.FindByAppIdAndIdRequest;
import com.fasterxml.uuid.Generators;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

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
    @Autowired
    private UserCacheClientBaseApi userCacheClientBaseApi;

    @Test
    public void test_0001_addUser() {
        User user = User.builder()
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

        User findUser = userBaseApi.getOne(User.builder().id(user.getId()).build()).check();

        Assert.assertNotNull(findUser);

        log.info("addUser success");
    }

    @Test
    public void test_0010_findByAppIdAndIdFromMultiCacheOrDb() {
        User user = User.builder()
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

        User findUser = userBaseApi.getOne(User.builder().id(user.getId()).build()).check();

        FindByAppIdAndIdRequest findByAppIdAndIdRequest = FindByAppIdAndIdRequest.builder()
                .id(findUser.getId())
                .appId(findUser.getAppId())
                .build();

        User userDb = userCacheClientBaseApi.findByAppIdAndIdFromMultiCacheOrDb(findByAppIdAndIdRequest).check();

        Assert.assertNotNull(userDb);

        User userMultiCache = userCacheClientBaseApi.findByAppIdAndIdFromMultiCache(findByAppIdAndIdRequest).check();

        Assert.assertNotNull(userMultiCache);

    }
}
