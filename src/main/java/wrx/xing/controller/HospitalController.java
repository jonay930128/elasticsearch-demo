package wrx.xing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import wrx.xing.domain.Hospital;
import wrx.xing.response.Result;
import wrx.xing.response.SuccessResult;
import wrx.xing.service.HospitalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-06-17 11:23
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(value = "/query",method = RequestMethod.POST)
	public Result query(@RequestParam Integer grade, HttpServletRequest request, HttpServletResponse response){
		List<Hospital> list = hospitalService.getHospitalByGrade(grade);
		return new SuccessResult(list);
	}
}
