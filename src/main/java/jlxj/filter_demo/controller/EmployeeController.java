package jlxj.filter_demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jlxj.filter_demo.common.R;
import jlxj.filter_demo.entity.Employee;
import jlxj.filter_demo.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author 阿强
 * @Date2025/3/24 16:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        //1、获取密码
        String password = employee.getPassword();
        //2、查询数据库该用户是否存在
        //利用mybatis-plus构造查询语句
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getName,employee.getName());
        //得到查询结果
        Employee emp = employeeServiceImpl.getOne(queryWrapper);

        //3.如果没有查询到则返回登录失败结果
        if(emp == null){
            return R.error("登录失败");
        }

        //4.密码比对，如果不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)){
            return R.error("登录失败");
        }
        //5.登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * 员工退出
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前登录用户的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    @GetMapping("/test")
    public String test (){
        return "完成登录，成功访问";
    }


}
