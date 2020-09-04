package ace.user.base.api.web.dal;


import ace.fw.restful.base.api.plugin.mybatisplus.MybatisPlusDbService;
import ace.user.base.define.dao.entity.User;

/**
 * <p>
 * 用户基础信息表 服务类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-07-23
 */
public interface UserDbService extends MybatisPlusDbService<User, String> {

}
