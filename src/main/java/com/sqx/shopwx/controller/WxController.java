package com.sqx.shopwx.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sqx.shopwx.mapper.CategoryMapper;
import com.sqx.shopwx.mapper.OrderMapper;
import com.sqx.shopwx.mapper.ProductMapper;
import com.sqx.shopwx.mapper.ShoppingMapper;
import com.sqx.shopwx.pojo.OrderBean;
import com.sqx.shopwx.pojo.ProductBean;
import com.sqx.shopwx.pojo.ShoppingBean;
import com.sqx.shopwx.pojo.WxResp;
import com.sqx.shopwx.utils.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wx")
public class WxController extends BaseController {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;

    //   localhost:8080/wx/index，这个地址浏览器可以访问，小程序可以访问
    @GetMapping("/index")
    public void index(Integer cid, HttpServletResponse resp) {
        WxResp r = new WxResp();//r只是一个普通对象
        r.category = categoryMapper.selectList(null);
        if (!r.category.isEmpty()) {

            r.product = cid != null ? productMapper.getProduct(cid) :
                    productMapper.getProduct(r.category.get(0).getId());
        }
        r.hot = productMapper.getHot();
        outRespJson(r, resp);//可以把一个对象转换成JSON字符串输出到浏览器或小程序中
    }

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/order")
    public void orderlist(Integer oid, HttpServletResponse resp) {
        WxResp r = new WxResp();
        r.order = orderMapper.selectList(null);
        outRespJson(r, resp);
    }

    @PostMapping("/order")
    public void order(OrderBean bean, HttpServletResponse resp) {

        System.out.println(bean.getJson());//?
        //json字符串转对象或数组，固定写法，使用谷歌研发的gson jar包

        List<ProductBean> product = new Gson().fromJson(bean.getJson(), new TypeToken<List<ProductBean>>() {
        }.getType());
        WxResp r = new WxResp();
        String alert = NotNullUtil.isBlankAlert(bean);
        if (alert != null) {//有错误
            r.fail(alert);//失败了
        } else if (product.isEmpty()) {
            r.fail("购物车空空如也");
        } else {
            bean.setCtime(new Date());//当前时间即为下单时间
            orderMapper.insert(bean);
            System.out.println(bean.getId());//新增订单的oid
            for (ProductBean p : product) {
                ShoppingBean s = new ShoppingBean(bean.getId(), p.getId(), p.getNum());
                shoppingMapper.insert(s);

            }

        }
        outRespJson(r, resp);
    }

}
