package com.sancheck.bank.utils;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: fengyuxiang
 * @ClassName: GenerateDaoProxy
 * @version: 1.0
 * @description:
 * @create: 3/2/2023
 */
public class GenerateDaoProxy {
    public static Object generate(SqlSession sqlSession, Class daoInterface){
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass(daoInterface.getName() + "Proxy");

        CtClass ctInterface = pool.makeInterface(daoInterface.getName());

        ctClass.addInterface(ctInterface);

        Method[] methods = daoInterface.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            try {
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");

                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg" + i);
                    if (i != parameterTypes.length - 1) {
                        methodCode.append(",");
                    }
                }

                methodCode.append(")");
                methodCode.append("{");

                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = SqlSessionUtil.openSession();");
                String sqlId = daoInterface.getName() + "." + method.getName();
                SqlCommandType sqlCommandType =  sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                if (sqlCommandType == SqlCommandType.INSERT){

                }
                if (sqlCommandType == SqlCommandType.DELETE){

                }
                if (sqlCommandType == SqlCommandType.UPDATE){
                    methodCode.append("return sqlSession.update(\""+sqlId+"\",arg0);");
                }
                if (sqlCommandType == SqlCommandType.SELECT){
                    String returnType = method.getReturnType().getName();
                    methodCode.append("return ("+ returnType +") sqlSession.selectOne(\""+sqlId+"\",arg0);");
                }


                methodCode.append("}");

                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);

            } catch (Exception e){
                e.printStackTrace();
            }
        });


        Object obj = null;

        try {
            Class<?> clazz = ctClass.toClass();
            obj = clazz.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }

        return obj;





    }
}
