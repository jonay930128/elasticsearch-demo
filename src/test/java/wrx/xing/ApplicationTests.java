package wrx.xing;

import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wrx.xing.domain.Hospital;
import wrx.xing.mapper.HospitalMapper;
import wrx.xing.util.JsonUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private TransportClient client;
	@Autowired(required = false)
	private HospitalMapper mapper;

	private String index = "hospital";
	private String type = "test";

	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsert() throws Exception {
		for (int i = 0; i < 20; i++) {
			Hospital hospital = new Hospital();
			hospital.setHospitalName(getRandomChar());
			hospital.setAddress(getRandomChar());
			hospital.setGrade((int)(Math.random() * 100));
			hospital.setPhone(getTel());
			mapper.insert(hospital);
			String json = JsonUtil.objToJson(hospital);
			Map o = (Map)JsonUtil.jsonToObj(json, HashMap.class);
			client.prepareIndex(index, type, hospital.getPkId().toString())
					.setSource(o).execute().get();
		}

	}

	//随机生成常见汉字
	public static String getRandomChar() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int highCode;
			int lowCode;

			Random random = new Random();

			highCode = (176 + Math.abs(random.nextInt(39))); //B0 + 0~39(16~55) 一级汉字所占区
			lowCode = (161 + Math.abs(random.nextInt(93))); //A1 + 0~93 每区有94个汉字

			byte[] b = new byte[2];
			b[0] = (Integer.valueOf(highCode)).byteValue();
			b[1] = (Integer.valueOf(lowCode)).byteValue();

			builder.append(new String(b, "GBK"));
		}
		return new String(builder.toString().getBytes(),"UTF-8");
	}

	private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
	private static String getTel() {
		int index=getNum(0,telFirst.length-1);
		String first=telFirst[index];
		String second=String.valueOf(getNum(1,888)+10000).substring(1);
		String third=String.valueOf(getNum(1,9100)+10000).substring(1);
		return first+second+third;
	}

	public static int getNum(int start,int end) {
		return (int)(Math.random()*(end-start+1)+start);
	}

}
