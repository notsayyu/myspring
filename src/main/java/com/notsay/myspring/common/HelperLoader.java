package com.notsay.myspring.common;

import com.notsay.myspring.helper.BeanHelper;
import com.notsay.myspring.helper.ClassHelper;
import com.notsay.myspring.helper.ControllerHelper;
import com.notsay.myspring.helper.IocHelper;
import com.notsay.myspring.util.ClassUtil;

/**
 * @description: 到目前为止, 我们创建了ClassHelper, BeanHelper, IocHelper, ControllerHelper这四个Helper类,
 * 我们需要一个入口程序来加载他们(实际上是加载静态代码块), 当然就算没有这个入口程序, 这些类也会被加载,
 * 我们这里只是为了让加载更加集中
 * @author: dsy
 * @date: 2020/8/21 16:59
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
