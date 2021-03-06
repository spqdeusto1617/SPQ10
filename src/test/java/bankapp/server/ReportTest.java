package bankapp.server;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the ReportTest class 
 */
public class ReportTest {

	@Test
	/**
	 * @brief create a valid report 
	 */
	public void validReport(){
		Report report = new Report("user1", "user2", 4124, "1", "2");
		assertTrue(report != null);
		assertThat(report.getAccNum1(), is("1"));
        assertThat(report.getAccNum2(), is("2"));
        assertThat(report.getUser1(), is("user1"));
        assertThat(report.getUser2(), is("user2"));
        assertThat(report.getMoney(), is(4124L));
      
	}
}
