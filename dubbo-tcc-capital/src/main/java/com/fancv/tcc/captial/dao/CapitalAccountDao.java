package com.fancv.tcc.captial.dao;


import com.fancv.tcc.captial.entity.CapitalAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by changming.xie on 4/2/16.
 */
@Mapper
public interface CapitalAccountDao {

    CapitalAccount findByUserId(long userId);

    int update(CapitalAccount capitalAccount);
}
