package com.dori.modules.sys.entity;

import com.dori.common.persistence.IdEntity;
import com.dori.common.utils.excel.annotation.ExcelField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 用户Entity
 * @author ThinkGem
 * @version 2013-5-15
 */
@Entity
@Table(name = "sys_user")
@DynamicInsert @DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends IdEntity<User> {

    private static final long serialVersionUID = 1L;
    private String loginName;// 登录名
    private String password;// 密码
    private String no;		// 工号
    private String name;	// 姓名
    private String email;	// 邮箱
    private String phone;	// 电话
    private String mobile;	// 手机
    private String userType;// 用户类型
    private String loginIp;	// 最后登陆IP
    private Date loginDate;	// 最后登陆日期


    public User() {
        super();
    }

    public User(String id) {
        this();
        this.id = id;
    }





    @Length(min=1, max=100)
    @ExcelField(title="登录名", align=2, sort=30)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @JsonIgnore
    @Length(min=1, max=100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min=1, max=100)
    @ExcelField(title="姓名", align=2, sort=40)
    public String getName() {
        return name;
    }

    @Length(min=1, max=100)
    @ExcelField(title="工号", align=2, sort=45)
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Email @Length(min=0, max=200)
    @ExcelField(title="邮箱", align=1, sort=50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min=0, max=200)
    @ExcelField(title="电话", align=2, sort=60)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min=0, max=200)
    @ExcelField(title="手机", align=2, sort=70)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Transient
    @ExcelField(title="备注", align=1, sort=900)
    public String getRemarks() {
        return remarks;
    }

    @Length(min=0, max=100)
    @ExcelField(title="用户类型", align=2, sort=80, dictType="sys_user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Transient
    @ExcelField(title="创建时间", type=0, align=1, sort=90)
    public Date getCreateDate() {
        return createDate;
    }

    @ExcelField(title="最后登录IP", type=1, align=1, sort=100)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title="最后登录日期", type=1, align=1, sort=110)
    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }



    @Transient
    public boolean isAdmin(){
        return isAdmin(this.id);
    }

    @Transient
    public static boolean isAdmin(String id){
        return id != null && id.equals("1");
    }

//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}
}