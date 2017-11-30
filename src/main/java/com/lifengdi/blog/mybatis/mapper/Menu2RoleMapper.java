package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.Menu2Role;
import com.lifengdi.blog.bean.Menu2RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Menu2RoleMapper {
    long countByExample(Menu2RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu2Role record);

    int insertSelective(Menu2Role record);

    List<Menu2Role> selectByExample(Menu2RoleExample example);

    Menu2Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu2Role record);

    int updateByPrimaryKey(Menu2Role record);
}