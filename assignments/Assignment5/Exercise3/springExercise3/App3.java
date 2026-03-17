package cg.demo.springExercise3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class App3 {
	public static void main( String[] args )
    {
        System.out.println( "Starting Application...." );
        
        ApplicationContext ac =new ClassPathXmlApplicationContext("springConf3.xml"); 
        
        SBU3 sbu1= (SBU3) ac.getBean("sbu1");

        System.out.println(sbu1);

        System.out.println( "Closing Application...." );
    }

}
