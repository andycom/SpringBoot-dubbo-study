package com.fancv.dubbo.order.dao;



import com.fancv.dubbo.order.domain.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by twinkle.zhou on 16/11/10.
 */
@Mapper
public interface ProductDao {

    Product findById(long productId);

    List<Product> findByShopId(long shopId);
}
