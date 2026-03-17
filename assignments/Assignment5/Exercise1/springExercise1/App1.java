package cg.demo.springExercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cg.demo.springExercise1.Employee1;


public class App1 
{
	public static void main( String[] args )
    {
        System.out.println( "Starting Application...." );
        
        ApplicationContext ac =new ClassPathXmlApplicationContext("springConf1.xml"); 
        Employee1 e= (Employee1) ac.getBean("e1");
        
     

        System.out.println(e);

        System.out.println( "Closing Application...." );
    }
}
