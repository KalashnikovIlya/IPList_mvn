package org.example;

import java.util.ArrayList;

public class IPList {

    long addressOne;
    long addressTwo;
    ArrayList<Long> addressList = new ArrayList<>();



    public IPList(long addressOne, long addressTwo){
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        getAddressList();
    }

    private void getAddressList (){
        if (addressOne > addressTwo) {
            long temp = addressOne;
            addressOne = addressTwo;
            addressTwo = temp;
        }
        for(long i = ++addressOne; i < addressTwo; i++){
            addressList.add(i);
        }
    }

}
