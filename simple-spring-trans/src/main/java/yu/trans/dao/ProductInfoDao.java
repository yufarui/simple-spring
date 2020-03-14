package yu.trans.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int updateProductInfo(Integer productId) {
		String sql = "update product_info set store=store-1 where product_id=?";
		return jdbcTemplate.update(sql, productId);
	}

	public Integer qryStore(Integer productId) {
		String sql = "select store from product_info where product_id=" + productId;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
