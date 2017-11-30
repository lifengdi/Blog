package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.User;
import com.lifengdi.blog.bean.UserExample;
import com.lifengdi.blog.bean.UserKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    @Select("SELECT * FROM T_USER WHERE id = #{id}")
    User selectById(Integer id);
}