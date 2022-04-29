package com.yuanQi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuanQi.common.core.controller.BaseController;
import com.yuanQi.common.core.domain.AjaxResult;
import com.yuanQi.common.core.domain.entity.SysUser;
import com.yuanQi.common.utils.StringUtils;
import com.yuanQi.framework.shiro.service.SysRegisterService;
import com.yuanQi.system.service.ISysConfigService;

/**
 * 注册验证
 * 
 * @author yuanQi
 */
@Controller
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public AjaxResult ajaxRegister(SysUser user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
