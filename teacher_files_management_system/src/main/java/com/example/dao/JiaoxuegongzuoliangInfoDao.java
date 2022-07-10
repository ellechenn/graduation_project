package com.example.dao;

import com.example.entity.JiaoxuegongzuoliangInfo;
import com.example.vo.JiaoxuegongzuoliangInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JiaoxuegongzuoliangInfoDao extends Mapper<JiaoxuegongzuoliangInfo> {
    List<JiaoxuegongzuoliangInfoVo> findByXingming(@Param("xingming") String xingming);
	List<JiaoxuegongzuoliangInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("gonghao") String gonghao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jiaoxuegongzuoliang_info where gonghao = #{gonghao}")
    JiaoxuegongzuoliangInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM jiaoxuegongzuoliang_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}
