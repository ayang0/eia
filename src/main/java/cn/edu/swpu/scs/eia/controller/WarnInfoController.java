package cn.edu.swpu.scs.eia.controller;


import cn.edu.swpu.scs.eia.service.IWarnInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.edu.swpu.scs.eia.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.edu.swpu.scs.eia.common.Result;

import cn.edu.swpu.scs.eia.entity.WarnInfo;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunyang
 * @since 2022-05-03
 */
@RestController
@RequestMapping("/warn-info")
public class WarnInfoController {

    @Resource
    private IWarnInfoService warnInfoService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody WarnInfo warnInfo) {
        if (warnInfo.getId() == null) { // 新增
            warnInfo.setTime(DateUtil.now());  // new Date()
            warnInfo.setUser(TokenUtils.getCurrentUser().getNickname());
        }

        warnInfoService.saveOrUpdate(warnInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        warnInfoService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        warnInfoService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(warnInfoService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(warnInfoService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        QueryWrapper<WarnInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(warnInfoService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

