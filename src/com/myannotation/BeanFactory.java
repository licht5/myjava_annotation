package com.myannotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tianfeihan on 2017/12/3.
 */
public class BeanFactory {
    public static MyUserService createService(){
        //1 目标
        final MyUserService myuserService = new MyUserServiceIm();
        //2切面
        final MyMethod mymethod = new MyMethod();
        MyUserService proxService = (MyUserService)Proxy.newProxyInstance(
                BeanFactory.class.getClassLoader(),
                myuserService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //前执
                        mymethod.before();

                        //执行目标类的方法
                        Object obj = method.invoke(myuserService, args);

                        //后执
                        mymethod.after();

                        return obj;
                    }
                });

        return proxService;
    }

}
