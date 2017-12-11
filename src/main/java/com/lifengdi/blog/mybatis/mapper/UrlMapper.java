package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.Url;
import com.lifengdi.blog.bean.UrlExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UrlMapper {
    long countByExample(UrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Url record);

    int insertSelective(Url record);

    List<Url> selectByExampleWithBLOBs(UrlExample example);

    List<Url> selectByExample(UrlExample example);

    Url selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKeyWithBLOBs(Url record);

    int updateByPrimaryKey(Url record);
}