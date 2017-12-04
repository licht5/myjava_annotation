package com.myannotation;

/**
 * Created by tianfeihan on 2017/12/3.
 */
public class TestJ {
    public static void main (String args []){

        MyUserService myuserService = BeanFactory.createService();
        myuserService.addOneUser();

    }

}
