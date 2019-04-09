package wrx.xing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import wrx.xing.log.LogAspects;
import wrx.xing.service.MathCalculator;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

	/**
	 * 业务逻辑类加入容器中
	 * @return
	 */
	@Bean
	public MathCalculator calculator(){
		return new MathCalculator();
	}

	/**
	 * 切面类加入到容器中
	 * @return
	 */
	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}