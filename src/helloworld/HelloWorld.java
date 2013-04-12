package helloworld;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class HelloWorld
{
	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException
	{
		String sEnglish = "apple";
		System.out.println(sEnglish.length());
		for (byte bt : sEnglish.getBytes())
		{
			System.out.print(String.format("%02X ", bt));
		}
		System.out.println();
		
		String sChinese = "苹果";
		System.out.println(sChinese.length());
		for (byte bt : sChinese.getBytes())
		{
			System.out.print(String.format("%02X ", bt));
		}
		System.out.println();
		
		String s = "苹果apple";
		System.out.println(s.length());
		for (byte bt : s.getBytes())
		{
			System.out.print(String.format("%02X ", bt));
		}
		System.out.println();
		
		// URL url = HelloWorld.class.getResource("/");
		URL url = HelloWorld.class.getClassLoader().getResource(
			"firststep/test.txt");
		System.out.println(url.toString());
		System.out.println(url.toURI().toString());
		File file = new File(url.toURI());
		System.out.println(file);
		
		runCmd("notepad");
	}
	
	/**
	 * 运行命令行程序
	 * 
	 * @param cmdLine 
	 */
	private static void runCmd(String cmdLine)
	{
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		try
		{
			process = runtime.exec(cmdLine);
		}
		catch (Exception e)
		{
			System.out.println("Error executing notepad.");
		}
	}
}
