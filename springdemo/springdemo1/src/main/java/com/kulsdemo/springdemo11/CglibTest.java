package com.kulsdemo.springdemo11;

import org.junit.Test;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 7:28 下午
 */
public class CglibTest {

    @Test
    public void test1() {
        //使用Enhancer来给某个类创建代理类，步骤
        //1.创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2.通过setSuperclass来设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(Service1.class);
        /*3.设置回调，需实现org.springframework.cglib.proxy.Callback接口，
        此处我们使用的是org.springframework.cglib.proxy.MethodInterceptor，也是一个接口，实现了Callback接口，
        当调用代理对象的任何方法的时候，都会被MethodInterceptor接口的invoke方法处理*/
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 代理对象方法拦截器
             * @param o 代理对象
             * @param method 被代理的类的方法，即Service1中的方法
             * @param objects 调用方法传递的参数
             * @param methodProxy 方法代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("调用方法:" + method);
                //可以调用MethodProxy的invokeSuper调用被代理类的方法
                //从方法名称的意思可以看出是调用父类，实际对某个类创建代理，
                // cglib底层通过修改字节码的方式为Service1类创建了一个子类。
                Object result = methodProxy.invokeSuper(o, objects);
                return result;
            }
        });
        //4.获取代理对象,调用enhancer.create方法获取代理对象，这个方法返回的是Object类型的，所以需要强转一下
        Service1 proxy = (Service1) enhancer.create();
        //5.调用代理对象的方法
        proxy.m1();
        proxy.m2();
   }



    @Test
    public void test2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service2.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("调用方法:" + method);
                Object result = methodProxy.invokeSuper(o, objects);
                return result;
            }
        });
        Service2 proxy = (Service2) enhancer.create();
        proxy.m1(); //@1

        //从输出中可以看出m1和m2方法都被拦截器处理了，
        // 而m2方法是在Service1的m1方法中调用的，也被拦截处理了。
        //spring中的@configuration注解就是采用这种方式实现的
    }


    @Test
    public void test3() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service3.class);
        //当调用某个类的任何方法的时候，都希望返回一个固定的值，此时可以使用FixedValue接口
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "kuls";
            }
        });
        Service3 proxy = (Service3) enhancer.create();
        System.out.println(proxy.m1());//@1
        System.out.println(proxy.m2()); //@2
        System.out.println(proxy.toString());//@3
    }



    @Test
    public void test6() {
        //Callback接口下面有个子接口org.springframework.cglib.proxy.NoOp，
        // 将这个作为Callback的时候，被调用的方法会直接放行，像没有任何代理一样
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service3.class);
        enhancer.setCallback(NoOp.INSTANCE);
        Service3 proxy = (Service3) enhancer.create();
        System.out.println(proxy.m1());
        System.out.println(proxy.m2());
        //从输出中可以看出，被调用的方法没有被代理做任何处理，直接进到目标类Service3的方法中了。
    }




//    由于需求中要对不同的方法做不同的处理，所以需要有2个Callback对象，当调用代理对象的方法的时候，
//    具体会走哪个Callback呢，此时会通过CallbackFilter中的accept来判断，
//    这个方法返回callbacks数组的索引。

   @Test
    public void test4(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service4.class);
        Callback[] callback = {new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long starTime = System.nanoTime();
                Object result = methodProxy.invokeSuper(o, objects);
                long endTime = System.nanoTime();
                System.out.println(method + "，耗时(纳秒):" + (endTime - starTime));
                return result;
            }
        },
        new FixedValue() {
            @Override
            public Object loadObject() throws Exception {

                return "kuls";
            }
        }};
        enhancer.setCallbacks(callback);
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                //获取当前调用的方法的名称
                String methodName = method.getName();
                /**
                 * 方法名称以insert开头，
                 * 返回callbacks中的第1个Callback对象来处理当前方法，
                 * 否则使用第二个Callback处理被调用的方法
                 */
                return methodName.startsWith("insert") ? 0 : 1;
            }
        });
       Service4 proxy = (Service4) enhancer.create();
       System.out.println("---------------");
       proxy.insert1();
       System.out.println("---------------");
       proxy.insert2();
       System.out.println("---------------");
       System.out.println(proxy.get1());
       System.out.println("---------------");
       System.out.println(proxy.get2());
       //代码说明：
       //由于需求中要对不同的方法做不同的处理，所以需要有2个Callback对象，
       // 当调用代理对象的方法的时候，具体会走哪个Callback呢，
       // 此时会通过CallbackFilter中的accept来判断，这个方法返回callbacks数组的索引。
   }


    @Test
    public void test5() {
        Enhancer enhancer = new Enhancer();
        //创建2个Callback
        Callback costTimeCallback = (MethodInterceptor) (Object o, Method method, Object[] objects, MethodProxy methodProxy) -> {
            long starTime = System.nanoTime();
            Object result = methodProxy.invokeSuper(o, objects);
            long endTime = System.nanoTime();
            System.out.println(method + "，耗时(纳秒):" + (endTime - starTime));
            return result;
        };
        //下面这个用来拦截所有get开头的方法，返回固定值的
        Callback fixdValueCallback = (FixedValue) () -> "kuls";

        CallbackHelper callbackHelper = new CallbackHelper(Service4.class, null) {
            @Override
            protected Object getCallback(Method method) {
                return method.getName().startsWith("insert") ? costTimeCallback : fixdValueCallback;
            }
        };
        enhancer.setSuperclass(Service4.class);
        //调用enhancer的setCallbacks传递Callback数组
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        /**
         * 设置CallbackFilter,用来判断某个方法具体走哪个Callback
         */
        enhancer.setCallbackFilter(callbackHelper);
        Service4 proxy = (Service4) enhancer.create();
        System.out.println("---------------");
        proxy.insert1();
        System.out.println("---------------");
        proxy.insert2();
        System.out.println("---------------");
        System.out.println(proxy.get1());
        System.out.println("---------------");
        System.out.println(proxy.get2());

    }



    @Test
    public void test7() {
        //创建Service1代理
        Service1 service1 = CostTimeProxy.createProxy(new Service1());
        service1.m1();

        System.out.println("-------");
        //创建Service3代理
        Service3 service3 = CostTimeProxy.createProxy(new Service3());
        System.out.println(service3.m1());
    }


    @Test
    public void test8() {
        //创建Service1代理
        Service1 service1 = NameProxy.createProxy(new Service1());
        service1.m1();

        System.out.println("-------");
        //创建Service3代理
        Service3 service3 = NameProxy.createProxy(new Service3());
        System.out.println(service3.m1());
    }
    //Java动态代理只能够对接口进行代理，不能对普通的类进行代理（因为所有生成的代理类的父类为Proxy，Java类继承机制不允许多重继承）；CGLIB能够代理普通类；
    //Java动态代理使用Java原生的反射API进行操作，在生成类上比较高效；CGLIB使用ASM框架直接对字节码进行操作，在类的执行过程中比较高效
}
