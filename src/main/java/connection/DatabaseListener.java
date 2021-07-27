package connection;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import oracle.jdbc.pool.OracleDataSource;

@WebListener
public class DatabaseListener implements ServletContextListener{
	
	public void contextInitialized (ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setUser("hr");
			ods.setPassword("hr");
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ctx.setAttribute("oracleDataSource", ods);
			System.out.println("Created OracleDataSource successfully");
		}catch(Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
}