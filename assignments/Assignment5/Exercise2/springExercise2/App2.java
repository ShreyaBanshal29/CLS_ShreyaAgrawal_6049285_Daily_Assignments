package cg.demo.springExercise2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main( String[] args )
    {
        System.out.println( "Starting Application...." );
        
        ApplicationContext ac =new ClassPathXmlApplicationContext("springConf2.xml"); 
        
        Employee2 e1= (Employee2) ac.getBean("emp1");

        System.out.println(e1);

        System.out.println( "Closing Application...." );
    }

}
