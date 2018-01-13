package com.realtor.jx.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * autour: lewish
 * created at: 2018/1/7 19:39
*/
public class FakeData {
    private static class SingletonHolder{
        private static FakeData INSTANCE = new FakeData();
    }
    public static FakeData getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public List<ContractListItemData> getContractList(){
        List<ContractListItemData> list = new ArrayList<>();
        for (int i=0;i<9;i++){
            list.add(new ContractListItemData(i+1,"renter"+i+1,"18511257775","2014.05.05"));
        }
        return list;
    }
}
