package com.example.dao;

import com.example.entity.KeyanlunwenInfo;
import com.example.vo.KeyanlunwenInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface KeyanlunwenInfoDao extends Mapper<KeyanlunwenInfo> {
    List<KeyanlunwenInfoVo> findByXingming(@Param("xingming") String xingming);
	List<KeyanlunwenInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("gonghao") String gonghao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from keyanlunwen_info where gonghao = #{gonghao}")
    KeyanlunwenInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM keyanlunwen_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}
