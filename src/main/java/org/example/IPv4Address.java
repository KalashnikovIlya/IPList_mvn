package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv4Address {

    String normalAddress;
    long decimalAddress;


    public IPv4Address(String address){
        if(checkNormalAddress(address)){
            normalAddress = address;
            getDecimalAddress();
        }
        else{
            throw new IllegalArgumentException("Некорректный адрес");
        }
    }

    public IPv4Address(long address){
        if(checkDecimalAddress(address)){
            decimalAddress = address;
            getNormalAddress();
        }
        else{
            throw new IllegalArgumentException("Некорректный адрес");
        }
    }

    private void getDecimalAddress() {
        String normalAddressPlusPoint = normalAddress + ".";
        StringBuilder segment = new StringBuilder();
        double degree = 3;
        long decimalAddress = 0;

        for(int i = 0; i < normalAddressPlusPoint.length(); i++) {
            if(normalAddressPlusPoint.charAt(i) == '.') {
                decimalAddress = (long) (decimalAddress + Long.parseLong(segment.toString()) * (Math.pow(256, degree)));
                degree--;
                segment = new StringBuilder();
            }
            else {
                segment.append(normalAddressPlusPoint.charAt(i));
            }
        }
        this.decimalAddress = decimalAddress;
    }

    private void getNormalAddress() {
        long integerFromDivision;
        normalAddress = "." + decimalAddress % 256;
        integerFromDivision = decimalAddress / 256;
        normalAddress = "." + integerFromDivision % 256 + normalAddress;
        integerFromDivision = integerFromDivision / 256;
        normalAddress = "." + integerFromDivision % 256 + normalAddress;
        integerFromDivision = integerFromDivision / 256;
        normalAddress = integerFromDivision % 256 + normalAddress;
    }

    private boolean checkNormalAddress(String address){
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private boolean checkDecimalAddress(long address){
        final long MAXIP = (long) Math.pow(2, 32);
        return (0 <= address && address <= MAXIP);
    }

}
