package yu.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

@MappedJdbcTypes(JdbcType.TIMESTAMP)
@MappedTypes(Long.class)
public class LongTypeHandler extends BaseTypeHandler<Long> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
		ps.setDate(i, new Date(parameter));
	}

	@Override
	public Long getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getDate(columnName).getTime();
	}

	@Override
	public Long getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getDate(columnIndex).getTime();
	}

	@Override
	public Long getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getDate(columnIndex).getTime();
	}
}
