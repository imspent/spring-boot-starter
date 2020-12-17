package im.spent.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MySqlCoreMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
