package com.yuanQi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuanQi.common.annotation.Log;
import com.yuanQi.common.enums.BusinessType;
import com.yuanQi.system.domain.SysUserinfo;
import com.yuanQi.system.service.ISysUserinfoService;
import com.yuanQi.common.core.controller.BaseController;
import com.yuanQi.common.core.domain.AjaxResult;
import com.yuanQi.common.utils.poi.ExcelUtil;
import com.yuanQi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author yuanQi
 * @date 2022-02-18
 */
@Controller
@RequestMapping("/system/userinfo")
public class SysUserinfoController extends BaseController
{
    private String prefix = "system/userinfo";

    @Autowired
    private ISysUserinfoService sysUserinfoService;

    @RequiresPermissions("system:userinfo:view")
    @GetMapping()
    public String userinfo()
    {
        return prefix + "/userinfo";
    }

    /**
     * 查询用户信息列表
     */
    @RequiresPermissions("system:userinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserinfo sysUserinfo)
    {
        startPage();
        List<SysUserinfo> list = sysUserinfoService.selectSysUserinfoList(sysUserinfo);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @RequiresPermissions("system:userinfo:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUserinfo sysUserinfo)
    {
        List<SysUserinfo> list = sysUserinfoService.selectSysUserinfoList(sysUserinfo);
        ExcelUtil<SysUserinfo> util = new ExcelUtil<SysUserinfo>(SysUserinfo.class);
        return util.exportExcel(list, "用户信息数据");
    }

    /**
     * 新增用户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息
     */
    @RequiresPermissions("system:userinfo:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUserinfo sysUserinfo)
    {
        return toAjax(sysUserinfoService.insertSysUserinfo(sysUserinfo));
    }

    /**
     * 修改用户信息
     */
    @RequiresPermissions("system:userinfo:edit")
    @GetMapping("/edit/{userinfoId}")
    public String edit(@PathVariable("userinfoId") Long userinfoId, ModelMap mmap)
    {
        SysUserinfo sysUserinfo = sysUserinfoService.selectSysUserinfoByUserinfoId(userinfoId);
        mmap.put("sysUserinfo", sysUserinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息
     */
    @RequiresPermissions("system:userinfo:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUserinfo sysUserinfo)
    {
        return toAjax(sysUserinfoService.updateSysUserinfo(sysUserinfo));
    }

    /**
     * 删除用户信息
     */
    @RequiresPermissions("system:userinfo:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUserinfoService.deleteSysUserinfoByUserinfoIds(ids));
    }
}
