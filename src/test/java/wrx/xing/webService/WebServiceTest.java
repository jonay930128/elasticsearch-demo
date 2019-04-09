package wrx.xing.webService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-06-15 14:13
 */
@WebService
public class WebServiceTest {
	public String getValue(String name){
		return "欢迎你！ "+name;
	}

	public static void main(String[] args) {
		Endpoint.publish("http://10.0.56.238:8099/Service/ServiceHello", new WebServiceTest());
		System.out.println("发布成功!");
	}
}
