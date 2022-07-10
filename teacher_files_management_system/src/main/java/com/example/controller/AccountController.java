package com.example.controller;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.*;
import com.example.exception.CustomException;

import com.example.service.AdminInfoService;
import com.example.service.JiaoshixinxiInfoService;import com.example.service.ShiziduiwuInfoService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import cn.hutool.json.JSONUtil;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    @Value("${authority.info}")
    private String authorityStr;

    @Resource
    private AdminInfoService adminInfoService;
	@Resourceprivate JiaoshixinxiInfoService jiaoshixinxiInfoService;@Resourceprivate ShiziduiwuInfoService shiziduiwuInfoService;
	






    @PostMapping("/login")
    public Result<Account> login(@RequestBody Account account,  HttpServletRequest request) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getMima()) || account.getLevel() == null) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        String level = account.getLevel();
        Account login = new Account();
        if (level.equals("管理员")) {
            login = adminInfoService.login(account.getUsername(), account.getMima());
        }
		if (level.equals("教师")) {
            login = jiaoshixinxiInfoService.login(account.getUsername(), account.getMima());
            //yoxusxhenhe if(login.getStatus().equals("否")){return Result.error("500","帐号未审核通过，请联系管理员");}
        }if (level.equals("师资队伍")) {
            login = shiziduiwuInfoService.login(account.getUsername(), account.getMima());
            //yoxusxhenhe if(login.getStatus().equals("否")){return Result.error("500","帐号未审核通过，请联系管理员");}
        }
		
//        if (2 == level) {
//            login = sellerInfoService.login(account.getUsername(), account.getMima());
//        }
//        if (level.equals("用户")) {
//            login = userInfoService.login(account.getUsername(), account.getMima());
//            if(login.getStatus().equals("否")){
//                return Result.error("500","状态异常，请联系管理员");
//            }
//        }
//        if (level.equals("员工")) {
//            login = yuangongxinxiInfoService.login(account.getUsername(), account.getMima());
//            if(login.getStatus().equals("否")){
//                return Result.error("500","状态异常，请联系管理员");
//            }
//        }

        request.getSession().setAttribute("user", login);
        return Result.success(login);
    }

  

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return Result.success();
    }

    @GetMapping("/auth")
    public Result getAuth(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        if(user == null) {
            return Result.error("401", "未登录");
        }
        return Result.success(user);
    }

    @GetMapping("/getAccountInfo")
    public Result<Object> getAccountInfo(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("user");
        if (account == null) {
            return Result.success(new Object());
        }
        String level = account.getLevel();
        if (level.equals("管理员")) {
            return Result.success(adminInfoService.findById(account.getId()));
        }
		if (level.equals("教师")) { return Result.success(jiaoshixinxiInfoService.findById(account.getId())); }if (level.equals("师资队伍")) { return Result.success(shiziduiwuInfoService.findById(account.getId())); }
//          if (level.equals("管理员")) {
//            return Result.success(sellerInfoService.findById(account.getId()));
//        }
//        if (level.equals("用户")) {
//            return Result.success(userInfoService.findById(account.getId()));
//        }
//
//        if (level.equals("医生")) {
//            return Result.success(yishengxinxiInfoService.findById(account.getId()));
//        }
//        if (level.equals("员工")) {
//            return Result.success(yuangongxinxiInfoService.findById(account.getId()));
//        }


        return Result.success(new Object());
    }

    @GetMapping("/getSession")
    public Result<Map<String, String>> getSession(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("user");
        if (account == null) {
            return Result.success(new HashMap<>(1));
        }
        Map<String, String> map = new HashMap<>(1);
        map.put("username", account.getUsername());
        return Result.success(map);
    }

    @GetMapping("/getAuthority")
    public Result<List<AuthorityInfo>> getAuthorityInfo() {
        List<AuthorityInfo> authorityInfoList = JSONUtil.toList(JSONUtil.parseArray(authorityStr), AuthorityInfo.class);
        return Result.success(authorityInfoList);
    }

    /**
     * 获取当前用户所能看到的模块信息
     * @param request
     * @return
     */
    @GetMapping("/authority")
    public Result<List<Integer>> getAuthorityInfo(HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute("user");
        if (user == null) {
            return Result.success(new ArrayList<>());
        }
        JSONArray objects = JSONUtil.parseArray(authorityStr);
        for (Object object : objects) {
            JSONObject jsonObject = (JSONObject) object;
            if (user.getLevel().equals(jsonObject.getStr("level"))) {
                JSONArray array = JSONUtil.parseArray(jsonObject.getStr("models"));
                List<Integer> modelIdList = array.stream().map((o -> {
                    JSONObject obj = (JSONObject) o;
                    return obj.getInt("modelId");
                })).collect(Collectors.toList());
                return Result.success(modelIdList);
            }
        }
        return Result.success(new ArrayList<>());
    }

    @GetMapping("/permission/{modelId}")
    public Result<List<Integer>> getPermission(@PathVariable Integer modelId, HttpServletRequest request) {
        List<AuthorityInfo> authorityInfoList = JSONUtil.toList(JSONUtil.parseArray(authorityStr), AuthorityInfo.class);
        Account user = (Account) request.getSession().getAttribute("user");
        if (user == null) {
            return Result.success(new ArrayList<>());
        }
        Optional<AuthorityInfo> optional = authorityInfoList.stream().filter(x -> x.getLevel().equals(user.getLevel())).findFirst();
        if (optional.isPresent()) {
            Optional<AuthorityInfo.Model> firstOption = optional.get().getModels().stream().filter(x -> x.getModelId().equals(modelId)).findFirst();
            if (firstOption.isPresent()) {
                List<Integer> info = firstOption.get().getOperation();
                return Result.success(info);
            }
        }
        return Result.success(new ArrayList<>());
    }

    @PutMapping("/updateMima")
    public Result updateMima(@RequestBody Account info, HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("user");
        if (account == null) {
            return Result.error(ResultCode.USER_NOT_EXIST_ERROR.code, ResultCode.USER_NOT_EXIST_ERROR.msg);
        }
        String oldMima = SecureUtil.md5(info.getMima());
        if (!oldMima.equals(account.getMima())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setMima(SecureUtil.md5(info.getNewMima()));
        String level = account.getLevel();
        if (level.equals("管理员")) {
            AdminInfo adminInfo = new AdminInfo();
            BeanUtils.copyProperties(info, adminInfo);
            adminInfoService.update(adminInfo);
        }
		if (level.equals("教师")) {
            JiaoshixinxiInfo jiaoshixinxiInfo = new JiaoshixinxiInfo();
            BeanUtils.copyProperties(info, jiaoshixinxiInfo);
            jiaoshixinxiInfoService.update(jiaoshixinxiInfo);
        }if (level.equals("师资队伍")) {
            ShiziduiwuInfo shiziduiwuInfo = new ShiziduiwuInfo();
            BeanUtils.copyProperties(info, shiziduiwuInfo);
            shiziduiwuInfoService.update(shiziduiwuInfo);
        }
//          if (level.equals("管理员")) {
//            SellerInfo sellerInfo = new SellerInfo();
//            BeanUtils.copyProperties(info, sellerInfo);
//            sellerInfoService.update(sellerInfo);
//        }
//        if (level.equals("用户")) {
//            UserInfo userInfo = new UserInfo();
//            BeanUtils.copyProperties(info, userInfo);
//            userInfoService.update(userInfo);
//        }
//
//        if (level.equals("医生")) {
//            YishengxinxiInfo yishengxinxiInfo = new YishengxinxiInfo();
//            BeanUtils.copyProperties(info, yishengxinxiInfo);
//            yishengxinxiInfoService.update(yishengxinxiInfo);
//        }
//        if (level.equals("员工")) {
//            YuangongxinxiInfo yuangongxinxiInfo = new YuangongxinxiInfo();
//            BeanUtils.copyProperties(info, yuangongxinxiInfo);
//            yuangongxinxiInfoService.update(yuangongxinxiInfo);
//        }

        info.setLevel(level);
        info.setUsername(account.getUsername());
        // 清空session，让用户重新登录
        request.getSession().setAttribute("user", null);
        return Result.success();
    }
    @PostMapping("/resetMima")
    public Result resetMima(@RequestBody Account account) {
        String level = account.getLevel();
        if (level.equals("管理员")) {
            AdminInfo info = adminInfoService.findByUserName(account.getUsername());
            if (info == null) {
                return Result.error(ResultCode.USER_NOT_EXIST_ERROR.code, ResultCode.USER_NOT_EXIST_ERROR.msg);
            }
            info.setMima(SecureUtil.md5("123456"));
            adminInfoService.update(info);
        }
//         if (level.equals("管理员")) {
//            SellerInfo info = sellerInfoService.findByUserName(account.getUsername());
//            if (info == null) {
//                return Result.error(ResultCode.USER_NOT_EXIST_ERROR.code, ResultCode.USER_NOT_EXIST_ERROR.msg);
//            }
//            info.setMima(SecureUtil.md5("123456"));
//            sellerInfoService.update(info);
//        }
//        if (level.equals("用户")) {
//            UserInfo info = userInfoService.findByUserName(account.getUsername());
//            if (info == null) {
//                return Result.error(ResultCode.USER_NOT_EXIST_ERROR.code, ResultCode.USER_NOT_EXIST_ERROR.msg);
//            }
//            info.setMima(SecureUtil.md5("123456"));
//            userInfoService.update(info);
//        }

//         if (level.equals("医生")) {
//            YishengxinxiInfo info = yishengxinxiInfoService.findByUserName(account.getXingming());
//            if (info == null) {
//                return Result.error(ResultCode.USER_NOT_EXIST_ERROR.code, ResultCode.USER_NOT_EXIST_ERROR.msg);
//            }
//            info.setPassword(SecureUtil.md5("123456"));
//            yishengxinxiInfoService.update(info);
//
//        }

//        if (level.equals("员工")) {
//            YuangongxinxiInfo info = yuangongxinxiInfoService.findByGonghao(account.getGonghao());
//            if (info == null) {
//                return Result.error(ResultCode.USER_NOT_EXIST_ERROR.code, ResultCode.USER_NOT_EXIST_ERROR.msg);
//            }
//            info.setMima(SecureUtil.md5("123456"));
//            yuangongxinxiInfoService.update(info);
//
//        }


        return Result.success();
    }
}
