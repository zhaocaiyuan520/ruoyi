package com.yuanQi.system.mapper;

import java.util.List;
import com.yuanQi.system.domain.SysUserinfo;

/**
 * 用户信息Mapper接口
 * 
 * @author yuanQi
 * @date 2022-02-18
 */
public interface SysUserinfoMapper 
{
    /**
     * 查询用户信息
     * 
     * @param userinfoId 用户信息主键
     * @return 用户信息
     */
    public SysUserinfo selectSysUserinfoByUserinfoId(Long userinfoId);

    /**
     * 查询用户信息列表
     * 
     * @param sysUserinfo 用户信息
     * @return 用户信息集合
     */
    public List<SysUserinfo> selectSysUserinfoList(SysUserinfo sysUserinfo);

    /**
     * 新增用户信息
     * 
     * @param sysUserinfo 用户信息
     * @return 结果
     */
    public int insertSysUserinfo(SysUserinfo sysUserinfo);

    /**
     * 修改用户信息
     * 
     * @param sysUserinfo 用户信息
     * @return 结果
     */
    public int updateSysUserinfo(SysUserinfo sysUserinfo);

    /**
     * 删除用户信息
     * 
     * @param userinfoId 用户信息主键
     * @return 结果
     */
    public int deleteSysUserinfoByUserinfoId(Long userinfoId);

    /**
     * 批量删除用户信息
     * 
     * @param userinfoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysUserinfoByUserinfoIds(String[] userinfoIds);
}
