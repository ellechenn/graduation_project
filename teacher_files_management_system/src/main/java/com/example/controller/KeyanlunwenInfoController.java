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
import com.example.entity.KeyanlunwenInfo;
import com.example.dao.KeyanlunwenInfoDao;
import com.example.service.KeyanlunwenInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.KeyanlunwenInfoVo;
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
@RequestMapping(value = "/keyanlunwenInfo")
public class KeyanlunwenInfoController {

    @Resource
    private KeyanlunwenInfoService keyanlunwenInfoService;
	@Resource
    private KeyanlunwenInfoDao keyanlunwenInfoDao;

    @PostMapping
    public Result<KeyanlunwenInfo> add(@RequestBody KeyanlunwenInfoVo keyanlunwenInfo) {
        
		//mixmajixami
		keyanlunwenInfoService.add(keyanlunwenInfo);
        return Result.success(keyanlunwenInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        keyanlunwenInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody KeyanlunwenInfoVo keyanlunwenInfo) {
        keyanlunwenInfoService.update(keyanlunwenInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody KeyanlunwenInfoVo keyanlunwenInfo) {
//        keyanlunwenInfoService.update2(keyanlunwenInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<KeyanlunwenInfo> detail(@PathVariable Long id) {
        KeyanlunwenInfo keyanlunwenInfo = keyanlunwenInfoService.findById(id);
        return Result.success(keyanlunwenInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<KeyanlunwenInfo> changeStatus(@PathVariable Long id) {
        keyanlunwenInfoService.changeStatus(id);
        return Result.success();
    }
	

    @GetMapping
    public Result<List<KeyanlunwenInfoVo>> all() {
        return Result.success(keyanlunwenInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<KeyanlunwenInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(keyanlunwenInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<KeyanlunwenInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(keyanlunwenInfoService.findPageqt(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<KeyanlunwenInfo> register(@RequestBody KeyanlunwenInfo keyanlunwenInfo) {
//        if (StrUtil.isBlank(keyanlunwenInfo.getName()) || StrUtil.isBlank(keyanlunwenInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(keyanlunwenInfoService.add(keyanlunwenInfo));
//    }

    /**
    * ????????????excel????????????
    * @param file excel??????
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<KeyanlunwenInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(KeyanlunwenInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // ?????????????????????
            List<KeyanlunwenInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getXingming())).collect(Collectors.toList());
            for (KeyanlunwenInfo info : resultList) {
                keyanlunwenInfoService.add(info);
            }
        }
        return Result.success();
    }
	//yoxutonxgjitu
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. ??????excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("gonghao", "A??????");row.put("xingming", "A??????");row.put("shijian", "A??????");row.put("lunwenmingcheng", "A????????????");row.put("shifoufabiao", "A????????????");
		row.put("status", "???");
		row.put("level", "keyanlunwen");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. ???excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=keyanlunwenInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	@GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. ??????excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("gonghao", "A??????");row.put("xingming", "A??????");row.put("shijian", "A??????");row.put("lunwenmingcheng", "A????????????");row.put("shifoufabiao", "A????????????");

        row.put("status", "???");
        row.put("level", "??????");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = keyanlunwenInfoDao.daochuexcel();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. ???excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=keyanlunwenInfo.xlsx");

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

        series.setName(name + "??????");
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