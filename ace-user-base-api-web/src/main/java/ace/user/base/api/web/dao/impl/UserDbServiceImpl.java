package ace.user.base.api.web.dao.impl;


import ace.fw.restful.base.api.plugin.mybatisplus.impl.MybatisPlusDbServiceImpl;
import ace.user.base.api.web.dao.UserDbService;
import ace.user.base.api.web.dao.mapper.UserMapper;
import ace.user.base.define.dao.entity.User;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基础信息表 服务实现类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-07-23
 */
@Service
public class UserDbServiceImpl extends MybatisPlusDbServiceImpl<User, String, UserMapper>
        implements UserDbService {

}
