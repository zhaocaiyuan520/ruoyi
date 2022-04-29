package com.yuanQi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yuanQi.common.annotation.Excel;
import com.yuanQi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 sys_userinfo
 * 
 * @author yuanQi
 * @date 2022-02-18
 */
public class SysUserinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long userinfoId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userinfoUsername;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer userinfoAge;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String userinfoIdnumber;

    /** 性别（0男 1女 2未知） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String userinfoSex;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String userinfoStatus;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date userinfoBirthday;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String userinfoAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String userinfoPhone;

    public void setUserinfoId(Long userinfoId) 
    {
        this.userinfoId = userinfoId;
    }

    public Long getUserinfoId() 
    {
        return userinfoId;
    }
    public void setUserinfoUsername(String userinfoUsername) 
    {
        this.userinfoUsername = userinfoUsername;
    }

    public String getUserinfoUsername() 
    {
        return userinfoUsername;
    }
    public void setUserinfoAge(Integer userinfoAge) 
    {
        this.userinfoAge = userinfoAge;
    }

    public Integer getUserinfoAge() 
    {
        return userinfoAge;
    }
    public void setUserinfoIdnumber(String userinfoIdnumber) 
    {
        this.userinfoIdnumber = userinfoIdnumber;
    }

    public String getUserinfoIdnumber() 
    {
        return userinfoIdnumber;
    }
    public void setUserinfoSex(String userinfoSex) 
    {
        this.userinfoSex = userinfoSex;
    }

    public String getUserinfoSex() 
    {
        return userinfoSex;
    }
    public void setUserinfoStatus(String userinfoStatus) 
    {
        this.userinfoStatus = userinfoStatus;
    }

    public String getUserinfoStatus() 
    {
        return userinfoStatus;
    }
    public void setUserinfoBirthday(Date userinfoBirthday) 
    {
        this.userinfoBirthday = userinfoBirthday;
    }

    public Date getUserinfoBirthday() 
    {
        return userinfoBirthday;
    }
    public void setUserinfoAddress(String userinfoAddress) 
    {
        this.userinfoAddress = userinfoAddress;
    }

    public String getUserinfoAddress() 
    {
        return userinfoAddress;
    }
    public void setUserinfoPhone(String userinfoPhone) 
    {
        this.userinfoPhone = userinfoPhone;
    }

    public String getUserinfoPhone() 
    {
        return userinfoPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userinfoId", getUserinfoId())
            .append("userinfoUsername", getUserinfoUsername())
            .append("userinfoAge", getUserinfoAge())
            .append("userinfoIdnumber", getUserinfoIdnumber())
            .append("userinfoSex", getUserinfoSex())
            .append("userinfoStatus", getUserinfoStatus())
            .append("userinfoBirthday", getUserinfoBirthday())
            .append("userinfoAddress", getUserinfoAddress())
            .append("userinfoPhone", getUserinfoPhone())
            .toString();
    }
}
