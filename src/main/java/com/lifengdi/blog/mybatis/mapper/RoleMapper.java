package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.Role;
import com.lifengdi.blog.bean.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}