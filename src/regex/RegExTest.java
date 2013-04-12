package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author Administrator
 * 
 */
public class RegExTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // 1. 字符串包含验证

        // 查找以Java开头,任意结尾的字符串
        Pattern pattern = Pattern.compile("^Java.*");
        Matcher matcher = pattern.matcher("Java不是人");
        boolean b = matcher.matches();

        // 当条件满足时，将返回true，否则返回false
        System.out.println(b);

        // 2.以多条件分割字符串
        pattern = Pattern.compile("[, |]+");
        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
        for (int i = 0; i < strs.length; i++)
        {
            System.out.println(strs[i]);
        }

        // 3.文字替换（首次出现字符）
        pattern = Pattern.compile("正则表达式");
        matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");

        // 替换第一个符合正则的数据
        System.out.println(matcher.replaceFirst("Java"));

        // 4. 文字替换（全部）
        pattern = Pattern.compile("正则表达式");
        matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        // 替换第一个符合正则的数据
        System.out.println(matcher.replaceAll("Java"));

        // 5.文字替换（置换字符）
        pattern = Pattern.compile("正则表达式");
        matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
        StringBuffer sbr = new StringBuffer();
        while (matcher.find())
        {
            matcher.appendReplacement(sbr, "Java");
        }
        matcher.appendTail(sbr);
        System.out.println(sbr.toString());

        // 6.验证是否为邮箱地址
        String str = "ceponline@yahoo.com.cn";
        pattern = Pattern.compile("[//w//.//-]+@([//w//-]+//.)+[//w//-]+", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(str);
        System.out.println(matcher.matches());

        // 7. 去除html标记
        pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);

        // 8.查找html中对应条件字符串
        pattern = Pattern.compile("href=\"(.+?)\"");
        matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        if (matcher.find())
            System.out.println(matcher.group(1));

        // 9.截取http://地址
        // 截取url
        pattern = Pattern.compile("(http://|https://){1}[//w//.//-/:]+");
        matcher = pattern.matcher("dsdsds<http://dsds//gfgffdfd>fdf");
        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
        {
            buffer.append(matcher.group());
            buffer.append("/r/n");
            System.out.println(buffer.toString());
        }

        // 10.替换指定{}中文字
        str = "Java目前的发展史是由{0}年-{1}年";
        String[][] object = { new String[] { "//{0//}", "1995" }, new String[] { "//{1//}", "2007" } };
        System.out.println(replace(str, object));
    }

    public static String replace(final String sourceString, Object[] object)
    {
        String temp = sourceString;
        for (int i = 0; i < object.length; i++)
        {
            String[] result = (String[]) object[i];
            Pattern pattern = Pattern.compile(result[0]);
            Matcher matcher = pattern.matcher(temp);
            temp = matcher.replaceAll(result[1]);
        }
        return temp;
    }
}
