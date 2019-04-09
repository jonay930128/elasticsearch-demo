package wrx.xing.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-06-16 13:18
 */
@Aspect
public class LogAspects {
	private static final Logger logger = LoggerFactory.getLogger(LogAspects.class);

	/**
	 * 抽取公共的切入点表达式
	 * 	1、本类引用
	 * 	2、其他的切面引用
	 */
	@Pointcut("execution(public * wrx.xing.service.*.*(..))")
	public void pointCut(){};

//	@Before("pointCut()")
//	public void logStart(JoinPoint joinPoint){
//		String className = joinPoint.getSignature().getDeclaringTypeName();
//		String methodName = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		logger.info(className + "-->" + methodName + ",param:{}", Arrays.asList(args));
//	}
//
//	@After("pointCut()")
//	public void logEnd(JoinPoint joinPoint){
//		String className = joinPoint.getSignature().getDeclaringTypeName();
//		String methodName = joinPoint.getSignature().getName();
//		logger.info(className + "-->" + methodName + ",结束...@After");
//	}
//
//	@AfterReturning(value="pointCut()",returning="result")
//	public void logReturn(JoinPoint joinPoint,Object result){
//		String className = joinPoint.getSignature().getDeclaringTypeName();
//		String methodName = joinPoint.getSignature().getName();
//		logger.info(className + "-->" + methodName + ",正常返回...@AfterReturning:运行结果:{}",result);
//	}
//
//	@AfterThrowing(value="pointCut()",throwing="exception")
//	public void logException(JoinPoint joinPoint,Exception exception){
//		String className = joinPoint.getSignature().getDeclaringTypeName();
//		String methodName = joinPoint.getSignature().getName();
//		logger.info(className + "-->" + methodName + ",异常...异常信息:{}",exception);
//	}

	@Around("pointCut()")
	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		Object proceed = null;
		try {
			System.out.println("环绕.....");
			proceed = point.proceed();
			MethodSignature signature = (MethodSignature) point.getSignature();
			Class returnType = signature.getReturnType();
			System.out.println(signature.getParameterNames()[0]);
			System.out.println(returnType);
		}catch (Exception e){
			System.out.println("error...");
			e.printStackTrace();
		}

		return proceed;
	}
}
