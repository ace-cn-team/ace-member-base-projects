package ace.user.base.api.web.controller;

import ace.fw.restful.base.api.web.AbstractRestfulController;
import ace.user.base.api.web.dao.UserDbService;
import ace.user.base.define.dao.entity.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
public class UserBaseControllerImpl extends AbstractRestfulController<User, UserDbService>
        implements UserBaseController {

}
