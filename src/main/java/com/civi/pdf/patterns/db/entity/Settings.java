package com.civi.pdf.patterns.db.entity;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Settings implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private Integer     idSetting;
    private Users       users;
    private String      password;
    private String      email;
    private byte[]      image;
    private Boolean     isdelete;
    private Integer     apptype;
    private Boolean     issocial_auth;

    public Settings() {
    }

    public Settings(Integer idSetting, Users users, String password, String email, byte[] image, Boolean isdelete, Integer apptype, Boolean issocial_auth)
    {
        this.idSetting = idSetting;
        this.users = users;
        this.password = password;
        this.email = email;
        this.image = image;
        this.isdelete = isdelete;
        this.apptype = apptype;
        this.issocial_auth = issocial_auth;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }

    public Integer getIdSetting() {
        return idSetting;
    }

    public void setIdSetting(Integer idSetting) {
        this.idSetting = idSetting;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getApptype() {
        return apptype;
    }

    public void setApptype(Integer apptype) {
        this.apptype = apptype;
    }

    public Boolean getIssocial_auth() {
        return issocial_auth;
    }

    public void setIssocial_auth(Boolean issocial_auth) {
        this.issocial_auth = issocial_auth;
    }
}
