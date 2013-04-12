package basic;

enum Colors
{
	red;
}

public class EnumSample
{
	private enum Color {red, blue, yellow};
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Color color = Color.red;
		System.out.println(color);
		for (Color cl : Color.values())
		{
			System.out.println(cl);
		}
	}
}
