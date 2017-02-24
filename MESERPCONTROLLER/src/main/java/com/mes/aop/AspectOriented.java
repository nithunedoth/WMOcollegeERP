package com.mes.aop;

import java.util.ArrayList;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AspectOriented {
	
	
	/*@After("execution(* com.mes.controller.MesERPController.deploys(..))")
	public String retrunresponse(JoinPoint joinPoint){
		Object cdr=Arrays.toString(joinPoint.getArgs());
		System.out.println(cdr.toString());
		System.out.println("aff"+Arrays.toString(joinPoint.getArgs()));
		
		return "nithun";
	} */
	
	@AfterReturning(pointcut = "execution(* com.mes.controller.MesERPController.getSamples(..))", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		System.out.print("After ");
		System.out.print(joinPoint.getSignature().getName());
		System.out.println(" result is " + result);
		System.out.println(result.getClass());
		
}
	
	/*@After("execution(* com.mes.controller.MesERPController.getSamples(..))")*/
/*	@After("com.mes.controller.MesERPController.deploys()")*/
	/*@After("execution(* com.mes.controller.MesERPController.getSamples(..)) && args(account,..)")
	public String retrunresponse(JoinPoint joinPoint){
		System.out.println("hjhg"+joinPoint.toString());
		
		return "nithun";
	} */
	/*@AfterReturning(
		        pointcut="com.mes.controller.MesERPController.getSamples(..)",
		        returning="retVal")
	 public Object retrunresponse(Object retVal){
			System.out.println("hjhg"+retVal.toString());
			
			return retVal;
		}*/
	/*public String retrunresponse(JoinPoint joinPoint){
		System.out.println("hjhg"+joinPoint.toString());
		
		return "nithun";
	}*/
	
	
	
}
