package yu.step3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Component
public class FirstService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 测试 jdbcTemplate
     * @return
     */
    public Map test() {

        Map<String, Object> map = jdbcTemplate.queryForMap("select * from user;");
        return map;
    }
}
