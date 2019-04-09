package wrx.xing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wrx.xing.domain.Hospital;
import wrx.xing.mapper.HospitalMapper;
import wrx.xing.service.HospitalService;
import wrx.xing.service.MathCalculator;
import wrx.xing.template.CustomerMethod;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-06-17 11:27
 */
@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired(required = false)
	private HospitalMapper hospitalMapper;
	@Autowired
	private MathCalculator mathCalculator;

	@Override
	public List<Hospital> getHospitalByGrade(Integer grade) {
		/*List<Hospital> list = (List<Hospital>) mathCalculator.getTime(new CustomerMethod<List<Hospital>>() {
			@Override
			public List<Hospital> jsfMethod() {
				return hospitalMapper.getHospitalByGrade(grade);
			}
		});*/
		List list = hospitalMapper.getHospitalByGrade(grade);
		double i = (double) 1 / 0;
		System.out.println(i);
		System.out.println("执行.....");
		return list;
	}
}
