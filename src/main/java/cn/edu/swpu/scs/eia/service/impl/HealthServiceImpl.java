package cn.edu.swpu.scs.eia.service.impl;

import cn.edu.swpu.scs.eia.entity.Health;
import cn.edu.swpu.scs.eia.mapper.HealthMapper;
import cn.edu.swpu.scs.eia.service.IHealthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 监控表 服务实现类
 * </p>
 *
 * @author sunyang
 * @since 2022-05-07
 */
@Service
public class HealthServiceImpl extends ServiceImpl<HealthMapper, Health> implements IHealthService {

}
