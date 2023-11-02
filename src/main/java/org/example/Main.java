package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        IPv4Address addressOne;
        IPv4Address addressTwo;

        IPList ipList;

        System.out.println("Введите два IP адреса.");
        while (true) {
            try {
                System.out.println("1.");
                addressOne = new IPv4Address(in.next());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("2.");
                addressTwo = new IPv4Address(in.next());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Список адресов:");
        ipList = new IPList(addressOne.decimalAddress, addressTwo.decimalAddress);
        for (Long address : ipList.addressList) {
            System.out.println(new IPv4Address(address).normalAddress);
        }
    }
}