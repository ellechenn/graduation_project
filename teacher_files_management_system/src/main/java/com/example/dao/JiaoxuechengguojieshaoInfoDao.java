package com.example.dao;

import com.example.entity.JiaoxuechengguojieshaoInfo;
import com.example.vo.JiaoxuechengguojieshaoInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JiaoxuechengguojieshaoInfoDao extends Mapper<JiaoxuechengguojieshaoInfo> {
    List<JiaoxuechengguojieshaoInfoVo> findByXingming(@Param("xingming") String xingming);
	List<JiaoxuechengguojieshaoInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("gonghao") String gonghao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jiaoxuechengguojieshao_info where gonghao = #{gonghao}")
    JiaoxuechengguojieshaoInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM jiaoxuechengguojieshao_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}
