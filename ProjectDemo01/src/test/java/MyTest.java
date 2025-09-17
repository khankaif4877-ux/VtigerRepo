import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.clientname.projectname.genricutil.BaseClaseUtil.BaseClass;
@Listeners(com.clientname.projectname.genricutil.ListenerImplUtil.ListenerImplimentation.class)


public class MyTest extends BaseClass {
	@Test
	public void myTest() throws EncryptedDocumentException, IOException  {

		fu.writeDataInProperty("url2", "https://flipkart.com");
		String property = fu.readDataFromProperty("url");
		System.out.println(property);
		System.out.println("test Executed");
		String dataFromExcel = eu.readDataFromExcel("PhoneData", 0, 0);
		eu.writeDataInExcel("PhoneData", 5, 2, null);
		System.out.println(dataFromExcel);
		String value = fu.readDataFromJson("username");
		System.out.println(value);

	}
	
	public void myTest02() throws IOException, ParseException, InterruptedException {
		fu.writeDataInProperty("url3", "https://Amazon.com");
		String property = fu.readDataFromProperty("url");
		System.out.println(property);
		System.out.println("test Executed");
		String dataFromExcel = eu.readDataFromExcel("PhoneData", 0, 5);
		eu.writeDataInExcel("PhoneData", 5, 6, "randome String");
		System.out.println(dataFromExcel);
//		String value = fu.readDataFromJson("pass");
//		System.out.println(value);
	}	
	public void myTest03() throws IOException, ParseException, InterruptedException {
		fu.writeDataInProperty("url3", "https://Amazon.com");
		String property = fu.readDataFromProperty("url");
		System.out.println(property);
		System.out.println("test Executed");
		String dataFromExcel = eu.readDataFromExcel("PhoneData", 0, 5);
		eu.writeDataInExcel("PhoneData", 5, 6, "randome String");
		System.out.println(dataFromExcel);
//		String value = fu.readDataFromJson("pass");
//		System.out.println(value);
	}
}
