package com.wang.orderapp.mapper;

import com.wang.orderapp.domain.TArticle;
import com.wang.orderapp.domain.TArticleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TArticleMapper {
    @SelectProvider(type=TArticleSqlProvider.class, method="countByExample")
    int countByExample(TArticleExample example);

    @DeleteProvider(type=TArticleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TArticleExample example);

    @Delete({
        "delete from t_article",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_article (article_id, create_time, ",
        "update_time, url, ",
        "type, like_num)",
        "values (#{articleId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{url,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{likeNum,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(TArticle record);

    @InsertProvider(type=TArticleSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(TArticle record);

    @SelectProvider(type=TArticleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="like_num", property="likeNum", jdbcType=JdbcType.INTEGER)
    })
    List<TArticle> selectByExample(TArticleExample example);

    @Select({
        "select",
        "id, article_id, create_time, update_time, url, type, like_num",
        "from t_article",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="like_num", property="likeNum", jdbcType=JdbcType.INTEGER)
    })
    TArticle selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TArticleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TArticle record, @Param("example") TArticleExample example);

    @UpdateProvider(type=TArticleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TArticle record, @Param("example") TArticleExample example);

    @UpdateProvider(type=TArticleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TArticle record);

    @Update({
        "update t_article",
        "set article_id = #{articleId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "url = #{url,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "like_num = #{likeNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TArticle record);
}