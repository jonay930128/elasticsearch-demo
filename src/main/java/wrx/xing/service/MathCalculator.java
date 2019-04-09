package wrx.xing.service;

import wrx.xing.domain.Hospital;
import wrx.xing.template.BaseGetTimeTemplate;
import wrx.xing.template.CustomerMethod;

public class MathCalculator extends BaseGetTimeTemplate {
	
	public Hospital div(Hospital hospital,Integer id,String str){
		return hospital;
	}

	@Override
	protected Object abstractMethod(CustomerMethod method) {
		return method.jsfMethod();
	}

}