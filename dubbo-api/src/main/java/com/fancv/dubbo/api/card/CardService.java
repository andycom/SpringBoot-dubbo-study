package com.fancv.dubbo.api.card;

import org.mengyun.tcctransaction.api.EnableTcc;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface CardService {

    @EnableTcc
    public String record(int num);

}
