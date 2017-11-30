package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.SysArguments;
import com.lifengdi.blog.bean.SysArgumentsExample;
import com.lifengdi.blog.bean.SysArgumentsKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysArgumentsMapper {
    long countByExample(SysArgumentsExample example);

    int deleteByPrimaryKey(SysArgumentsKey key);

    int insert(SysArguments record);

    int insertSelective(SysArguments record);

    List<SysArguments> selectByExampleWithBLOBs(SysArgumentsExample example);

    List<SysArguments> selectByExample(SysArgumentsExample example);

    SysArguments selectByPrimaryKey(SysArgumentsKey key);

    int updateByPrimaryKeySelective(SysArguments record);

    int updateByPrimaryKeyWithBLOBs(SysArguments record);

    int updateByPrimaryKey(SysArguments record);
}