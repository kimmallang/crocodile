package com.mallang.crocodile.infrastructure;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HelloRepositoryTest {
	protected final JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	private DataSource dataSource;

	@Autowired
	private HelloRepository helloRepository;

	@BeforeEach
	public void beforeEach() {
		jdbcTemplate.setDataSource(dataSource);
	}

	@Test
	public void HELLO_테이블_전체_카운트_조회(){
		// given
		jdbcTemplate.update("INSERT INTO hello VALUES();");

		// when
		Integer count = helloRepository.countAll();

		// then
		Assertions.assertNotNull(count);
		Assertions.assertTrue(count > 0);
	}
}
