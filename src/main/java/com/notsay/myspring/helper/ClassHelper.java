package com.notsay.myspring.helper;

import com.notsay.myspring.annotation.Controller;
import com.notsay.myspring.annotation.Service;
import com.notsay.myspring.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 借助 ClassUtil 来实现 ClassHelper 助手类, 这个类的功能很重要, 大家需要仔细看一下.
 * ClassHelper 助手类在自身被加载的时候通过 ConfigHelper 助手类获取应用的基础包名, 然后通过 ClassUtil 工具类来获取基础包名下所有类,
 * 存储到 CLASS_SET 集合中. 除此之外, 其他的方法在后面的代码中会经常被使用到.
 * @author: dsy
 * @date: 2020/8/19 14:01
 */
public final class ClassHelper {

    /**
     * 定义类结合（存放基础包名下的所有类）
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        //获取基础包名
        String basePackage = ConfigHelper.getAppBasePackage();
        //获取基础包名下所有类
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取基础包名下的所有类
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取基础包名下所有Service类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取基础包名下所有 Controller 类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取基础包名下所有 Bean 类（包括：Controller、Service）
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /**
     * 获取基础包名下某父类的所有子类 或某接口的所有实现类
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            //isAssignableFrom() 指 superClass 和 cls 是否相同或 superClass 是否是 cls 的父类/接口
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取基础包名下带有某注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

}
