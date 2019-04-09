package wrx.xing;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wrx.xing.config.MainConfigOfAOP;
import wrx.xing.domain.Hospital;
import wrx.xing.service.HospitalService;
import wrx.xing.service.MathCalculator;
import wrx.xing.template.CustomerMethod;


public class IOCTest_AOP {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		Hospital hospital = new Hospital();
		hospital.setPhone("234");
		hospital.setAddress("lsfjlsdfj");
		hospital.setGrade(4);
		hospital.setHospitalName("hhh");
		hospital.setPkId(7979L);
		mathCalculator.div(hospital,234,"sdfs");
		
		applicationContext.close();
	}

	@Test
	public void test02(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

		HospitalService hospitalService = applicationContext.getBean(HospitalService.class);

		applicationContext.close();
	}

}