package wrx.xing.mapper;

import org.apache.ibatis.annotations.Mapper;
import wrx.xing.domain.Hospital;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-24 11:10
 */
@Mapper
public interface HospitalMapper {
	void insert(Hospital hospital);

	List<Hospital> getHospitalByGrade(Integer grade);
}
