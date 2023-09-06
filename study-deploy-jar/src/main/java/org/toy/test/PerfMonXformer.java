package org.toy.test;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-05-21 22:55
 * @describe
 */
public class PerfMonXformer implements ClassFileTransformer {
	@Override
	public byte[] transform(ClassLoader loader,
							String className, Class<?> classBeingRedefined,
							ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

		byte[] transformed = null;
		System.out.println("Transforming " + className);
		ClassPool pool = ClassPool.getDefault();
		CtClass cl = null;
		try{
		    cl = pool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer));
		    if(!cl.isInterface()){
				CtBehavior[] methods = cl.getDeclaredBehaviors();
				for (int i = 0; i < methods.length; i++) {
					if (!methods[i].isEmpty()){
						// 修改method字节码
						doMethod(methods[i]);
					}
				}
				transformed = cl.toBytecode();
			}
		}catch(Exception e){
			System.err.println("Cloud not instrument " + className + ", exception: " + e.getMessage());

		}finally{
		    if (cl != null){
		    	cl.detach();
			}
		}
		return transformed;
	}

	private void doMethod(CtBehavior method) throws NotFoundException, CannotCompileException {
		method.insertBefore("long stime = System.nanoTime();");
		method.insertAfter("System.out.println(\"leave " + method.getName() + " and time: \" + (System.nanoTime()- stime));");
	}



}
