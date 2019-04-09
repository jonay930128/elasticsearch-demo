package wrx.xing.service;

import wrx.xing.domain.Hospital;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-06-17 11:27
 */
public interface HospitalService {
	List<Hospital> getHospitalByGrade(Integer grade);
}
