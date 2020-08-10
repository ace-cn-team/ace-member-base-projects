package ace.user.base.api.web.biz;

import ace.fw.data.model.Sort;
import ace.fw.data.model.request.resful.PageQueryRequest;
import ace.fw.data.model.request.resful.WhereRequest;
import ace.fw.data.model.request.resful.entity.EntityUpdateRequest;
import ace.fw.util.DateUtils;
import ace.user.base.api.web.UserBaseApiWebApplication;
import ace.user.base.api.web.controller.UserBaseController;
import ace.user.base.define.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/8/4 17:42
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserBaseApiWebApplication.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestBaseApi {
    @Autowired
    private UserBaseController userBaseController;

    @Test
    public void test_0001_page() {
        User user = userBaseController.page(PageQueryRequest.builder()
                .pageIndex(1)
                .pageSize(1)
                .sorts(Arrays.asList(
                        Sort.builder()
                                .asc(true)
                                .field(User.ID)
                                .build()
                        )
                )
                .build()
        ).check().getData().get(0);
        String avatarUrl = DateUtils.getNowFormat(DateUtils.FROMAT_yyyyMMddHHmmssSS);
        String nickName = avatarUrl;

        WhereRequest whereRequest = new WhereRequest();
        whereRequest.eq("id", user.getId());
        User modifyUser = User.builder()
                .nickName(avatarUrl)
                .avatarUrl(avatarUrl)
                .id("1")
                .rowVersion(1)
                .build();
        boolean result = userBaseController.update(EntityUpdateRequest.<User>builder()
                .entity(modifyUser)
                .where(
                        WhereRequest.build()
                                .eq("id", modifyUser.getId())
                )
                .build()
        ).check();
        // boolean result = userBaseController.updateById(modifyUser).check();
        Assert.assertTrue(result);
        User updateedUser = userBaseController.getById(user.getId()).check();

        Assert.assertEquals(avatarUrl, updateedUser.getAvatarUrl());
        Assert.assertEquals(nickName, updateedUser.getNickName());

        Assert.assertNotEquals(user.getAvatarUrl(), avatarUrl);
        Assert.assertNotEquals(user.getNickName(), nickName);

        Assert.assertEquals(user.getSignature(), updateedUser.getSignature());
    }
}
