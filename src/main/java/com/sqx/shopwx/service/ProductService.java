package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.CategoryBean;
import com.sqx.shopwx.pojo.ProductBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService extends IService<ProductBean> {

    // 查询商品列表
    List<ProductBean> getProductList(Integer id);

    // 添加商品
    boolean addProduct(ProductBean productBean);

    // 删除商品
    boolean deleteProductById(Integer id);

    // 添加图片描述
    String logo(MultipartFile file) throws IOException;

    // 获取热卖商品
    List<ProductBean> getHotProduct();

    Page<ProductBean> getListByPage(long current, long limit, ProductBean productBean);
}
