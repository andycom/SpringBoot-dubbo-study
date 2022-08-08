package com.fancv.dubbo.redpacket.dao;


import com.fancv.dubbo.redpacket.entity.RedPacketAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by changming.xie on 4/2/16.
 */
@Mapper
public interface RedPacketAccountDao {

    RedPacketAccount findByUserId(long userId);

    int update(RedPacketAccount redPacketAccount);
}
