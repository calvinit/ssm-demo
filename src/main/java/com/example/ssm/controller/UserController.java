package com.example.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssm.converter.UserVoConverter;
import com.example.ssm.entity.User;
import com.example.ssm.service.IUserService;
import com.example.ssm.vo.PageVo;
import com.example.ssm.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;
    private UserVoConverter userVoConverter;

    @Autowired
    public UserController(@NonNull IUserService userService, @NonNull UserVoConverter userVoConverter) {
        this.userService = userService;
        this.userVoConverter = userVoConverter;
    }

    @ApiOperation(value = "分页查询用户列表")
    @GetMapping("/page")
    @ResponseBody
    public PageVo<UserVo> page(
            @ApiParam(value = "当前页", required = true, defaultValue = "1", example = "1")
            @RequestParam("pageNum") int pageNum,
            @ApiParam(value = "页面大小", required = true, defaultValue = "10", example = "10")
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        Page<User> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        page.setAsc(User.CREATE_DT, User.LAST_UPDATE_DT);

        IPage<User> userPage = userService.selectPage(page);
        List<User> userList = userPage.getRecords();
        List<UserVo> userVoList = userVoConverter.batchEntityToVo(userList);

        return new PageVo<UserVo>()
                .setPageNum(userPage.getCurrent())
                .setPageSize(userPage.getSize())
                .setPageTotal(userPage.getPages())
                .setRowTotal(userPage.getTotal())
                .setRowList(userVoList)
                .get();
    }

    @ApiOperation(value = "查询某个用户")
    @GetMapping("/{id}")
    @ResponseBody
    public User page(
            @ApiParam(value = "用户Id", required = true, example = "1")
            @PathVariable(value = "id") int id) {

        return userService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "获取所有00后用户列表")
    @GetMapping("/00/list")
    @ResponseBody
    public List<User> list00() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.ge(User::getBirthday, "2000-01-01");

        return userService.list(userLambdaQueryWrapper);
    }
}
