package com.yuanQi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuanQi.system.mapper.SysUserinfoMapper;
import com.yuanQi.system.domain.SysUserinfo;
import com.yuanQi.system.service.ISysUserinfoService;
import com.yuanQi.common.core.text.Convert;

/**
 * 用户信息Service业务层处理
 * 
 * @author yuanQi
 * @date 2022-02-18
 */
@Service
public class SysUserinfoServiceImpl implements ISysUserinfoService 
{
    @Autowired
    private SysUserinfoMapper sysUserinfoMapper;

    /**
     * 查询用户信息
     * 
     * @param userinfoId 用户信息主键
     * @return 用户信息
     */
    @Override
    public SysUserinfo selectSysUserinfoByUserinfoId(Long userinfoId)
    {
        return sysUserinfoMapper.selectSysUserinfoByUserinfoId(userinfoId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param sysUserinfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<SysUserinfo> selectSysUserinfoList(SysUserinfo sysUserinfo)
    {
        return sysUserinfoMapper.selectSysUserinfoList(sysUserinfo);
    }

    /**
     * 新增用户信息
     * 
     * @param sysUserinfo 用户信息
     * @return 结果
     */
    @Override
    public int insertSysUserinfo(SysUserinfo sysUserinfo)
    {
        return sysUserinfoMapper.insertSysUserinfo(sysUserinfo);
    }

    /**
     * 修改用户信息
     * 
     * @param sysUserinfo 用户信息
     * @return 结果
     */
    @Override
    public int updateSysUserinfo(SysUserinfo sysUserinfo)
    {
        return sysUserinfoMapper.updateSysUserinfo(sysUserinfo);
    }

    /**
     * 批量删除用户信息
     * 
     * @param userinfoIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysUserinfoByUserinfoIds(String userinfoIds)
    {
        return sysUserinfoMapper.deleteSysUserinfoByUserinfoIds(Convert.toStrArray(userinfoIds));
    }

    /**
     * 删除用户信息信息
     * 
     * @param userinfoId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysUserinfoByUserinfoId(Long userinfoId)
    {
        return sysUserinfoMapper.deleteSysUserinfoByUserinfoId(userinfoId);
    }
}
