package basic;

public class StaticInit
{
	public static String name = "name";
	
	static 
	{
		StaticInit.sb.append("1");
	}
	
	public static StringBuilder sb = new StringBuilder();
	
	public static String getSB()
	{
		return sb.toString();
	}
}
