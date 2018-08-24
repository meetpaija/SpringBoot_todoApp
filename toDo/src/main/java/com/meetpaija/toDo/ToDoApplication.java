package com.meetpaija.toDo;



import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.meetpaija.toDo.client.ServiceLocator;

//@ComponentScan("com.meetpaija")
@SpringBootApplication
@Configuration
@ImportResource("classpath*:BeanContext.xml")
public class ToDoApplication {

	public static void main(String[] args) {
		 java.util.Date dt = new java.util.Date();
			
		 java.text.SimpleDateFormat sdf =
		 new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		 String currentTime = sdf.format(dt);
		 System.out.println(currentTime);
		 /*Resource res=(Resource) new ClassPathResource("BeanContext.xml");
		 XmlBeanFactory factory =new XmlBeanFactory(res);
		 ServiceLocator service=new ServiceLocator();
		 service.setBeanFactory(factory);*/
		SpringApplication.run(ToDoApplication.class, args);
	}
}
