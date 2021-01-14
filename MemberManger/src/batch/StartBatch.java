package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class StartBatch
 *
 */
@WebListener
public class StartBatch implements ServletContextListener {
	//스케줄러 종료
	CronTriggerMaker js;
    /**
     * Default constructor. 
     */
    public StartBatch() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("MemberManger End");
    	js.shutdownScheduler();//스케쥴러 종료
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("MemberManger Start");
//    	js = new CronTriggerMaker("0/5 * * * * ?", SearchNoAnswerList.class);
//		js.createTrigger();
    }
	
}













