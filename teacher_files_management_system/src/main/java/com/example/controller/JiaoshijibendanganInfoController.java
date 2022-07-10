package com.example.controller;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.JiaoshijibendanganInfo;
import com.example.dao.JiaoshijibendanganInfoDao;
import com.example.service.JiaoshijibendanganInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.JiaoshijibendanganInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/jiaoshijibendanganInfo")
public class JiaoshijibendanganInfoController {

    @Resource
    private JiaoshijibendanganInfoService jiaoshijibendanganInfoService;
	@Resource
    private JiaoshijibendanganInfoDao jiaoshijibendanganInfoDao;

    @PostMapping
    public Result<JiaoshijibendanganInfo> add(@RequestBody JiaoshijibendanganInfoVo jiaoshijibendanganInfo) {
        

		jiaoshijibendanganInfoService.add(jiaoshijibendanganInfo);
        return Result.success(jiaoshijibendanganInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jiaoshijibendanganInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody JiaoshijibendanganInfoVo jiaoshijibendanganInfo) {
        jiaoshijibendanganInfoService.update(jiaoshijibendanganInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody JiaoshijibendanganInfoVo jiaoshijibendanganInfo) {
//        jiaoshijibendanganInfoService.update2(jiaoshijibendanganInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<JiaoshijibendanganInfo> detail(@PathVariable Long id) {
        JiaoshijibendanganInfo jiaoshijibendanganInfo = jiaoshijibendanganInfoService.findById(id);
        return Result.success(jiaoshijibendanganInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<JiaoshijibendanganInfo> changeStatus(@PathVariable Long id) {
        jiaoshijibendanganInfoService.changeStatus(id);
        return Result.success();
    }
	

    @GetMapping
    public Result<List<JiaoshijibendanganInfoVo>> all() {
        return Result.success(jiaoshijibendanganInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<JiaoshijibendanganInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(jiaoshijibendanganInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<JiaoshijibendanganInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(jiaoshijibendanganInfoService.findPageqt(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<JiaoshijibendanganInfo> register(@RequestBody JiaoshijibendanganInfo jiaoshijibendanganInfo) {
//        if (StrUtil.isBlank(jiaoshijibendanganInfo.getName()) || StrUtil.isBlank(jiaoshijibendanganInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(jiaoshijibendanganInfoService.add(jiaoshijibendanganInfo));
//    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<JiaoshijibendanganInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(JiaoshijibendanganInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<JiaoshijibendanganInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getXingming())).collect(Collectors.toList());
            for (JiaoshijibendanganInfo info : resultList) {
                jiaoshijibendanganInfoService.add(info);
            }
        }
        return Result.success();
    }
	@GetMapping("/get/jiaoshijibendangan_tj_xingbie")
    Result<List<EchartsData>> jiaoshijibendangan_tj_xingbie() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> jiaoshijibendangan_tj_xingbieList = jiaoshijibendanganInfoDao.jiaoshijibendangan_tj_xingbie();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : jiaoshijibendangan_tj_xingbieList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("教师基本档案按性别统计", list, typeMap);
        getBarData("教师基本档案按性别统计", list, typeMap);
        return Result.success(list);
    }
@GetMapping("/get/jiaoshijibendangan_tj_nianling")
    Result<List<EchartsData>> jiaoshijibendangan_tj_nianling() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> jiaoshijibendangan_tj_nianlingList = jiaoshijibendanganInfoDao.jiaoshijibendangan_tj_nianling();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : jiaoshijibendangan_tj_nianlingList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("教师基本档案按年龄统计", list, typeMap);
        getBarData("教师基本档案按年龄统计", list, typeMap);
        return Result.success(list);
    }
@GetMapping("/get/jiaoshijibendangan_tj_xueli")
    Result<List<EchartsData>> jiaoshijibendangan_tj_xueli() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> jiaoshijibendangan_tj_xueliList = jiaoshijibendanganInfoDao.jiaoshijibendangan_tj_xueli();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : jiaoshijibendangan_tj_xueliList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("教师基本档案按学历统计", list, typeMap);
        getBarData("教师基本档案按学历统计", list, typeMap);
        return Result.success(list);
    }

    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("gonghao", "A工号");
row.put("xingming", "A姓名");
row.put("xingbie", "A性别");
row.put("nianling", "A年龄");
row.put("xueli", "A学历");
row.put("xianzaizhicheng", "A现在职称");
row.put("minzu", "A民族");
row.put("dianhuahaoma", "A电话号码");
row.put("shenfenzheng", "A身份证");
row.put("youxiang", "A邮箱");
row.put("zhengzhimianmao", "A政治面貌");
row.put("renjiaokemu", "A任教科目");
row.put("jiatingzhuzhi", "A家庭住址");
row.put("shentizhuangkuang", "A身体状况");
row.put("xuexiao", "A学校");
row.put("zaibenxiaorenzhishijian", "A在本校任职时间");
row.put("xuexijingli", "A学习经历");
row.put("gongzuojingli", "A工作经历");
row.put("zhaopian", "A照片");

		row.put("status", "是");
		row.put("level", "jiaoshijibendangan");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=jiaoshijibendanganInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	@GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("gonghao", "A工号");
row.put("xingming", "A姓名");
row.put("xingbie", "A性别");
row.put("nianling", "A年龄");
row.put("xueli", "A学历");
row.put("xianzaizhicheng", "A现在职称");
row.put("minzu", "A民族");
row.put("dianhuahaoma", "A电话号码");
row.put("shenfenzheng", "A身份证");
row.put("youxiang", "A邮箱");
row.put("zhengzhimianmao", "A政治面貌");
row.put("renjiaokemu", "A任教科目");
row.put("jiatingzhuzhi", "A家庭住址");
row.put("shentizhuangkuang", "A身体状况");
row.put("xuexiao", "A学校");
row.put("zaibenxiaorenzhishijian", "A在本校任职时间");
row.put("xuexijingli", "A学习经历");
row.put("gongzuojingli", "A工作经历");
row.put("zhaopian", "A照片");


        row.put("status", "是");
        row.put("level", "权限");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = jiaoshijibendanganInfoDao.daochuexcel();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=jiaoshijibendanganInfo.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	private void getPieData(String name, List<EchartsData> pieList, Map<String, Double> dataMap) {
        EchartsData pieData = new EchartsData();
        EchartsData.Series series = new EchartsData.Series();

        Map<String, String> titleMap = new HashMap<>(2);
        titleMap.put("text", name);
        pieData.setTitle(titleMap);

        series.setName(name + "比例");
        series.setType("pie");
        series.setRadius("55%");

        List<Object> objects = new ArrayList<>();
        List<Object> legendList = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Double value = dataMap.get(key);
            objects.add(new JSONObject().putOpt("name", key).putOpt("value", value));
            legendList.add(key);
        }
        series.setData(objects);

        pieData.setSeries(Collections.singletonList(series));
        Map<String, Boolean> map = new HashMap<>();
        map.put("show", true);
        pieData.setTooltip(map);

        Map<String, Object> legendMap = new HashMap<>(4);
        legendMap.put("orient", "vertical");
        legendMap.put("x", "left");
        legendMap.put("y", "center");
        legendMap.put("data", legendList);
        pieData.setLegend(legendMap);

        pieList.add(pieData);
    }

    private void getBarData(String name, List<EchartsData> barList, Map<String, Double> dataMap) {
        EchartsData barData = new EchartsData();
        EchartsData.Series series = new EchartsData.Series();

        List<Object> seriesObjs = new ArrayList<>();
        List<Object> xAxisObjs = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Double value = dataMap.get(key);
            xAxisObjs.add(key);
            seriesObjs.add(value);
        }

        series.setType("bar");
        series.setName(name);
        series.setData(seriesObjs);
        barData.setSeries(Collections.singletonList(series));

        Map<String, Object> xAxisMap = new HashMap<>(1);
        xAxisMap.put("data", xAxisObjs);
        barData.setxAxis(xAxisMap);

        barData.setyAxis(new HashMap<>());

        Map<String, Object> legendMap = new HashMap<>(1);
        legendMap.put("data", Collections.singletonList(name));
        barData.setLegend(legendMap);

        Map<String, Boolean> map = new HashMap<>(1);
        map.put("show", true);
        barData.setTooltip(map);

        Map<String, String> titleMap = new HashMap<>(1);
        titleMap.put("text", name);
        barData.setTitle(titleMap);

        barList.add(barData);
    }
}