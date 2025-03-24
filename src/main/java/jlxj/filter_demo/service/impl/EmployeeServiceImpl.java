package jlxj.filter_demo.service.impl;

import jlxj.filter_demo.entity.Employee;
import jlxj.filter_demo.mapper.EmployeeMapper;
import jlxj.filter_demo.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 阿强
 * @since 2025-03-24
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
