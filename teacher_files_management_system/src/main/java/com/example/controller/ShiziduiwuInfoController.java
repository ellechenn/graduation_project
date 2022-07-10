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
import com.example.entity.ShiziduiwuInfo;
import com.example.dao.ShiziduiwuInfoDao;
import com.example.service.ShiziduiwuInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.ShiziduiwuInfoVo;
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
@RequestMapping(value = "/shiziduiwuInfo")
public class ShiziduiwuInfoController {

    @Resource
    private ShiziduiwuInfoService shiziduiwuInfoService;
	@Resource
    private ShiziduiwuInfoDao shiziduiwuInfoDao;

    @PostMapping
    public Result<ShiziduiwuInfo> add(@RequestBody ShiziduiwuInfoVo shiziduiwuInfo) {
        
		shiziduiwuInfo.setMima(SecureUtil.md5(shiziduiwuInfo.getMima()));
		shiziduiwuInfoService.add(shiziduiwuInfo);
        return Result.success(shiziduiwuInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        shiziduiwuInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ShiziduiwuInfoVo shiziduiwuInfo) {
        shiziduiwuInfoService.update(shiziduiwuInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody ShiziduiwuInfoVo shiziduiwuInfo) {
//        shiziduiwuInfoService.update2(shiziduiwuInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<ShiziduiwuInfo> detail(@PathVariable Long id) {
        ShiziduiwuInfo shiziduiwuInfo = shiziduiwuInfoService.findById(id);
        return Result.success(shiziduiwuInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<ShiziduiwuInfo> changeStatus(@PathVariable Long id) {
        shiziduiwuInfoService.changeStatus(id);
        return Result.success();
    }
	

    @GetMapping
    public Result<List<ShiziduiwuInfoVo>> all() {
        return Result.success(shiziduiwuInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<ShiziduiwuInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(shiziduiwuInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<ShiziduiwuInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(shiziduiwuInfoService.findPageqt(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<ShiziduiwuInfo> register(@RequestBody ShiziduiwuInfo shiziduiwuInfo) {
//        if (StrUtil.isBlank(shiziduiwuInfo.getName()) || StrUtil.isBlank(shiziduiwuInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(shiziduiwuInfoService.add(shiziduiwuInfo));
//    }

    /**
    * 批量通过excel添加信息
    file excel文件

    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<ShiziduiwuInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(ShiziduiwuInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<ShiziduiwuInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getZhanghao())).collect(Collectors.toList());
            for (ShiziduiwuInfo info : resultList) {
                shiziduiwuInfoService.add(info);
            }
        }
        return Result.success();
    }
	//yoxutonxgjitu
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("zhanghao", "A账号");
row.put("mima", "A密码");
row.put("mingcheng", "A名称");

		row.put("status", "是");
		row.put("level", "shiziduiwu");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=shiziduiwuInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	@GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("zhanghao", "A账号");
row.put("mima", "A密码");
row.put("mingcheng", "A名称");


        row.put("status", "是");
        row.put("level", "权限");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = shiziduiwuInfoDao.daochuexcel();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=shiziduiwuInfo.xlsx");

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