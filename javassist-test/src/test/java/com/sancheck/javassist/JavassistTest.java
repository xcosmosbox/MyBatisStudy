package com.sancheck.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.junit.Test;

import java.lang.reflect.Method;

//import java.lang.reflect.Method;

/**
 * @author: fengyuxiang
 * @ClassName: JavassistTest
 * @version: 1.0
 * @description:
 * @create: 3/2/2023
 */
public class JavassistTest {

    @Test
    public void testGenerateFirstClass() throws Exception{
//        ClassPool pool = ClassPool.getDefault();
//
//        CtClass ctClass = pool.makeClass("com.sancheck.bank.dao.impl.AccountDaoImpl");
//
//        String methodCode = "public void insert(){System.out.println(123);}";
//        CtMethod ctMethod = CtMethod.make(methodCode,ctClass);
//
//        ctClass.addMethod(ctMethod);
//
//        ctClass.toClass();
//
//
//        Class<?> clazz = Class.forName("com.sancheck.bank.dao.impl.AccountDaoImpl");
//
//        Object obj = clazz.newInstance();
//
//        Method insertMethod = clazz.getDeclaredMethod("insert");
//
//        insertMethod.invoke(obj);

        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("com.sancheck.javassist.Test");

        CtMethod ctMethod = new CtMethod(CtClass.voidType, "execute", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);

        ctMethod.setBody("{System.out.println(\"hello world\");}");

        ctClass.addMethod(ctMethod);

        Class<?> aClass = ctClass.toClass();

        Object o = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("execute");
        method.invoke(o);
    }

}
