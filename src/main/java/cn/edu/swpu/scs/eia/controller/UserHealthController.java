package cn.edu.swpu.scs.eia.controller;

import cn.edu.swpu.scs.eia.service.IHealthService;
import cn.edu.swpu.scs.eia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/5/8
 * @Copyright： sunyangqaq@foxmail.com
 */
@RestController
@RequestMapping("/userHealth")
public class UserHealthController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IHealthService healthService;


}
