package ace.user.base.api.web.biz;

import ace.fw.logic.common.util.AceUUIDUtils;
import ace.fw.restful.base.api.model.request.base.PageRequest;
import ace.fw.restful.base.api.model.request.base.PagerRequest;
import ace.fw.restful.base.api.util.QueryUtils;
import ace.fw.util.AceLocalDateTimeUtils;
import ace.fw.util.DateUtils;
import ace.user.base.api.web.UserBaseApiWebApplication;
import ace.user.base.api.web.controller.UserBaseController;
import ace.user.base.define.dao.entity.User;
import ace.user.base.define.dao.enums.user.UserSexEnum;
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
import java.util.Arrays;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/8/4 17:42
 * @description
 */
@Slf4j
@EnableFeignClients
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserBaseApiWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestUserBaseController {
    @Autowired
    private UserBaseController userBaseController;

    @Test
    public void test_0001_page() {
        this.saveUser();
        User user = userBaseController.page(PageRequest.builder()
                .pager(QueryUtils.pager(0, 1))
                .orderBy(QueryUtils.orderByAsc(User::getId))
                .build()
        ).check().getData().get(0);
        String avatarUrl = DateUtils.getNowFormat(DateUtils.FROMAT_yyyyMMddHHmmssSS);
        String nickName = avatarUrl;

        User modifyUser = User.builder()
                .nickName(avatarUrl)
                .avatarUrl(avatarUrl)
                .id(user.getId())
                .build();
        boolean result = userBaseController.updateByIdVersionAutoUpdate(modifyUser).check();
        Assert.assertTrue(result);
        User updatedUser = userBaseController.findById(user.getId()).check();

        Assert.assertEquals(avatarUrl, updatedUser.getAvatarUrl());
        Assert.assertEquals(nickName, updatedUser.getNickName());

        Assert.assertNotEquals(user.getAvatarUrl(), avatarUrl);
        Assert.assertNotEquals(user.getNickName(), nickName);

        Assert.assertEquals(user.getSignature(), updatedUser.getSignature());
    }

    public User saveUser() {
        User user = newUser();
        userBaseController.save(user).check();
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
