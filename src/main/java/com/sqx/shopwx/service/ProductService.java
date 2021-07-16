package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.ProductBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService extends IService<ProductBean> {

    // 查询商品列表
    List<ProductBean> getProductList(Integer id);

    // 根据id查询
    ProductBean getProductById(Integer id);

    // 添加商品
    boolean addProduct(ProductBean productBean);

    // 删除商品
    boolean deleteProductById(Integer id);

    // 修改商品
    boolean updateProduct(ProductBean productBean);

    // 添加图片描述
    String logo(MultipartFile file) throws IOException;

    // 修改图片描述
    boolean updateLogo(ProductBean productBean) throws IOException;

    // 修改图片
    boolean updateLogoPic(ProductBean productBean) throws IOException;

    // 获取热卖商品
    List<ProductBean> getHotProduct();

    // 分页条件查询
    Page<ProductBean> getListByPage(long current, long limit, ProductBean productBean);
}
