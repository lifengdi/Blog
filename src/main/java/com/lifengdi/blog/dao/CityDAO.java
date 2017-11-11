package com.lifengdi.blog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.lifengdi.blog.bean.City;

@Component
public class CityDAO {
	private final SqlSession sqlSession;

	public CityDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public City selectCityById(long id) {
		return this.sqlSession.selectOne("selectCityById", id);
	}
}

