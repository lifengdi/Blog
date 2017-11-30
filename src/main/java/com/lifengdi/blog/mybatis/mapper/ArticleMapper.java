package com.lifengdi.blog.mybatis.mapper;

import com.lifengdi.blog.bean.Article;
import com.lifengdi.blog.bean.ArticleExample;
import com.lifengdi.blog.bean.ArticleWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    ArticleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
}