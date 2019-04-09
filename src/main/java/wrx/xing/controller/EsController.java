package wrx.xing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrx.xing.service.EsService;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-21 20:41
 */
@RestController
@RequestMapping("/es")
public class EsController {
	@Autowired
	private EsService esService;

	@GetMapping("get")
	public Object get(){
		return esService.getAllData();
	}
}
