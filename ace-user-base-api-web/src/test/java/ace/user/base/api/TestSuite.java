package ace.user.base.api;

import ace.user.base.api.web.biz.TestUserBaseController;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/9/2 9:54
 * @description
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestUserBaseApi.class,
        TestUserBaseController.class
})
public class TestSuite {

}
