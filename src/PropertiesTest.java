import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest
{
	
	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException
	{
		Properties prop = new Properties();
		prop.load(new FileReader(PropertiesTest.class.getResource(
			"/main.properties").getPath()));
		System.out.println(prop.getProperty("1"));
		System.out.println(prop.getProperty("2"));
		prop.setProperty("2", "139139");
		prop.setProperty("1", "138138");
		prop.store(new FileWriter(PropertiesTest.class.getResource(
			"/main.properties").getPath()), "comm...");
	}
}
