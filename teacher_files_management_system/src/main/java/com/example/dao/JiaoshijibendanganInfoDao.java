package com.example.dao;

import com.example.entity.JiaoshijibendanganInfo;
import com.example.vo.JiaoshijibendanganInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JiaoshijibendanganInfoDao extends Mapper<JiaoshijibendanganInfo> {
    List<JiaoshijibendanganInfoVo> findByXingming(@Param("xingming") String xingming);
	List<JiaoshijibendanganInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("gonghao") String gonghao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jiaoshijibendangan_info where gonghao = #{gonghao}")
    JiaoshijibendanganInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM jiaoshijibendangan_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	@Select("SELECT distinct(xingbie) as aa,count(id) as bb FROM jiaoshijibendangan_info group by xingbie order by id")List<Map<String, Object>> jiaoshijibendangan_tj_xingbie();@Select("SELECT distinct(nianling) as aa,count(id) as bb FROM jiaoshijibendangan_info group by nianling order by id")List<Map<String, Object>> jiaoshijibendangan_tj_nianling();@Select("SELECT distinct(xueli) as aa,count(id) as bb FROM jiaoshijibendangan_info group by xueli order by id")List<Map<String, Object>> jiaoshijibendangan_tj_xueli();
	
	
    
	
	

}
