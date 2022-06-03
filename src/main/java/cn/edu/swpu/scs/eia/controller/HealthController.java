package cn.edu.swpu.scs.eia.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.edu.swpu.scs.eia.common.Constants;
import cn.edu.swpu.scs.eia.controller.dto.HealthDTO;
import cn.edu.swpu.scs.eia.entity.User;
import cn.edu.swpu.scs.eia.service.IUserService;
import cn.edu.swpu.scs.eia.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.edu.swpu.scs.eia.common.Result;

import cn.edu.swpu.scs.eia.service.IHealthService;
import cn.edu.swpu.scs.eia.entity.Health;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 监控表 前端控制器
 * </p>
 *
 * @author sunyang
 * @since 2022-05-07
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @Resource
    private IHealthService healthService;

    @Resource
    private IUserService userService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Health health) {
        // 验证用户名是否存在
        String username = health.getUsername();
        User one = userService.getOne(new QueryWrapper<User>().select("id").eq("username", username));
        if (Objects.isNull(one)) {
            return Result.error(Constants.CODE_600, "用户不存在");
        }
        health.setUserId(one.getId());
        healthService.saveOrUpdate(health);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        healthService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        healthService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(healthService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        Health health = healthService.getById(id);
        health.setUsername(userService.getOne(new QueryWrapper<User>().select("username").eq("id", health.getUserId())).getUsername());
        return Result.success(health);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        QueryWrapper<Health> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        Page<Health> page = healthService.page(new Page<>(pageNum, pageSize), queryWrapper);
        List<Health> records = page.getRecords();
        for (Health record : records) {
            record.setUsername(userService.getOne(new QueryWrapper<User>().select("username").eq("id", record.getUserId())).getUsername());
        }
        return Result.success(page);
    }

    @PostMapping("/save/dto")
    public Result saveDTO(@RequestBody HealthDTO healthDTO) {
        // 获取用户
        User currentUser = TokenUtils.getCurrentUser();
        // 设置选项
        Health health = new Health();
        health.setUserId(currentUser.getId());
        if (healthDTO.getOption1().equals("其他")){
            health.setOption1(healthDTO.getOtherText());
        } else {
            health.setOption1(healthDTO.getOption1());
        }
        health.setOption2(healthDTO.getOption2());
        health.setOption3(healthDTO.getOption3());
        health.setOption4(healthDTO.getOption4());
        health.setOption5(healthDTO.getOption5());
        //保存到数据库
        healthService.save(health);
        return Result.success();
    }

    @GetMapping("/page/user")
    public Result findPageByUserId(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam Integer userId) {
        QueryWrapper<Health> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return Result.success(healthService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {

        List<Health> list = healthService.list();

        ExcelWriter writer = ExcelUtil.getWriter(true);


        for (Health health : list) {
            health.setUsername(userService.getOne(new QueryWrapper<User>().select("username").eq("id", health.getUserId())).getUsername());
        }

        writer.addHeaderAlias("username","用户名");
        writer.addHeaderAlias("option1","健康情况");
        writer.addHeaderAlias("option2","体温（℃）");
        writer.addHeaderAlias("option3","是否出现发热");
        writer.addHeaderAlias("option4","是否与高风险接触");
        writer.addHeaderAlias("option5","是否出现疫情情况");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("健康信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }
}

