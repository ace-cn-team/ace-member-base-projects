package ace.user.base.api;

import ace.fw.logic.common.util.AceUUIDUtils;
import ace.fw.util.AceLocalDateTimeUtils;
import ace.user.base.api.cache.UserCacheClientBaseApi;
import ace.user.base.api.web.UserBaseApiWebApplication;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.dao.enums.user.UserSexEnum;
import ace.user.base.define.module.user.request.FindByAppIdAndIdRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 14:32
 * @description
 */
@Slf4j
@EnableFeignClients
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserBaseApiWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestUserBaseApi {


    private final static String TEST_MOBILE = "15099975787";
    @Autowired
    private UserBaseApi userBaseApi;
    @Autowired
    private UserCacheClientBaseApi userCacheClientBaseApi;

    @Test
    public void test_0001_addUser() {
        User user = this.saveUser();

        User findUser = userBaseApi.findById(user.getId()).check();

        Assert.assertNotNull(findUser);

        log.info("addUser success");
    }

    @Test
    public void test_0010_findByAppIdAndIdFromMultiCacheOrDb() {
        User user = this.saveUser();

        User findUser = userBaseApi.findById(user.getId()).check();

        FindByAppIdAndIdRequest findByAppIdAndIdRequest = FindByAppIdAndIdRequest.builder()
                .id(findUser.getId())
                .appId(findUser.getAppId())
                .build();

        User userDb = userCacheClientBaseApi.findByAppIdAndIdFromMultiCacheOrDb(findByAppIdAndIdRequest).check();

        Assert.assertNotNull(userDb);

        User userMultiCache = userCacheClientBaseApi.findByAppIdAndIdFromMultiCache(findByAppIdAndIdRequest).check();

        Assert.assertNotNull(userMultiCache);

    }

    public User saveUser() {
        User user = newUser();
        userBaseApi.save(user).check();
        return user;
    }

    public static User newUser() {
        return User.builder()
                .appId(AceUUIDUtils.generateTimeUUIDShort32())
                .avatarUrl("")
                .birthday(AceLocalDateTimeUtils.MIN_MYSQL)
                .createTime(LocalDateTime.now())
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .nickName(AceUUIDUtils.generateTimeUUIDShort32())
                .rowVersion(1)
                .sex(UserSexEnum.UNKNOWN.getCode())
                .signature(AceUUIDUtils.generateTimeUUIDShort32())
                .updateTime(LocalDateTime.now())
                .build();
    }
}
