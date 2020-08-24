package ace.user.base.api.web.dao.mapper;

import ace.fw.mybatis.plus.extension.mapper.AceBaseMapper;
import ace.user.base.define.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户基础信息表 Mapper 接口
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-07-23
 */
@Mapper
public interface UserMapper extends AceBaseMapper<User> {

}
