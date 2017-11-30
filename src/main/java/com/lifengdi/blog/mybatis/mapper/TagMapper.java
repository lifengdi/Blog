package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.Tag;
import com.lifengdi.blog.bean.TagExample;
import com.lifengdi.blog.bean.TagKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByPrimaryKey(TagKey key);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(TagKey key);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}