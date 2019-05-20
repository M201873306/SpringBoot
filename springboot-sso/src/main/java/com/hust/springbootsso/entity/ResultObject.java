package com.hust.springbootsso.entity;

public class ResultObject {
    private long status;
    private String Msg;
    private TbUser tbuser;
    private Boolean Data;
    public static ResultObject build(long status, String msg) {
        return new ResultObject(status, msg);
    }

    public ResultObject(long status, String msg) {
        this.status = status;
        Msg = msg;
    }
    public static ResultObject ok(String msg) {
        return new ResultObject(200, msg, true);
    }
    public static ResultObject ok(Boolean data) {
        return new ResultObject(200, "操作成功", true);
    }
    public static ResultObject ok() {
        return new ResultObject(200, "操作成功", true);
    }
    public static ResultObject ok(TbUser tbuser) {
        return new ResultObject(200, "操作成功",tbuser, true);
    }
    public ResultObject(long status, String msg, Boolean Data) {
        this.status = status;
        Msg = msg;
        this.Data = Data;
    }

    public ResultObject(long status, String msg, TbUser tbuser, Boolean data) {
        this.status = status;
        Msg = msg;
        this.tbuser = tbuser;
    }

    public Boolean getData() {
        return Data;
    }

    public void setData(Boolean data) {
        Data = data;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public TbUser getTbuser() {
        return tbuser;
    }

    public void setTbuser(TbUser tbuser) {
        this.tbuser = tbuser;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "status=" + status +
                ", Msg='" + Msg + '\'' +
                ", tbuser=" + tbuser +
                '}';
    }
}