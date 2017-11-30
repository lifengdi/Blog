package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.SysLog;
import com.lifengdi.blog.bean.SysLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogMapper {
    long countByExample(SysLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExampleWithBLOBs(SysLogExample example);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);
}