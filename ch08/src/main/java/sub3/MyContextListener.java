package sub3;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{
	// WAS의 실행/종료를 감지하는 리스너
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyContextListener contextInitialized...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyContextListener contextDestroyed...");
	}
}
