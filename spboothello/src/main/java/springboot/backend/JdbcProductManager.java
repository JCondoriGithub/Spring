package springboot.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JdbcProductManager implements ProductManager{

	@Autowired
	JdbcTemplate jdbc;
	
	public static class ProductRowConverter implements RowMapper<Product> {
		
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(rs.getLong("code"),rs.getString("name"), rs.getInt("price"));
		}
	}
	
	@Override
	public List<Product> getAll() {
		return jdbc.query("select * from products", new ProductRowConverter());
	}

	@Override
	public Product get(Long id) {
		return jdbc.queryForObject("select * from products where code=?", new Object[] { id },
				new ProductRowConverter());
	}

	@Override
	public void delete(Long id) {
		jdbc.update("delete from products where code=?", id);	
	}

	@Override
	public Product create(String name, int price) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("insert into products (name,price) values (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setInt(2, price);
			return ps;
		}, keyHolder);
		long key = keyHolder.getKey().longValue();
		return new Product(key, name, price);
	}

	
}
