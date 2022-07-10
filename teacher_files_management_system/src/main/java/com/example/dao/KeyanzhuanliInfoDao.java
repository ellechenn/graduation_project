package com.example.dao;

import com.example.entity.KeyanzhuanliInfo;
import com.example.vo.KeyanzhuanliInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface KeyanzhuanliInfoDao extends Mapper<KeyanzhuanliInfo> {
    List<KeyanzhuanliInfoVo> findByXingming(@Param("xingming") String xingming);
	List<KeyanzhuanliInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("gonghao") String gonghao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from keyanzhuanli_info where gonghao = #{gonghao}")
    KeyanzhuanliInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM keyanzhuanli_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}
