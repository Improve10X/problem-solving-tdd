package com.improve10x.fibonacciseries;

public class Fibonacci {
    public int findNthNumber(int n) {
        if(n <= 0){
            return -1;
        } else if(n == 1){
            return 0;
        } else if(n == 2){
            return 1;
        } else {
            return findNthNumber(n-1) + findNthNumber(n-2);
        }
    }
}
