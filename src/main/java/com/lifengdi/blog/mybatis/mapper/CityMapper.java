package com.lifengdi.blog.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lifengdi.blog.bean.City;

@Mapper
public interface CityMapper {

	@Select("SELECT * FROM CITY WHERE id = #{id}")
    City selectCityById(@Param("id") int id);
}

