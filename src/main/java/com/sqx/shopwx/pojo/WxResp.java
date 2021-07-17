package com.sqx.shopwx.pojo;

import java.util.List;

public class WxResp {
    //响应码，code=1代表成功，code=0代表失败
    public  int code=1;
    //错误提示，默认没错误
    public String msg="";
    public void fail(String msg){
        this.code=0;//失败
        this.msg=msg;//有错误提示

    }
    public List<CategoryBean> category;
    public List<ProductBean> product;
    public List<OrderBean> order;
    public List<ProductBean> hot;

}
