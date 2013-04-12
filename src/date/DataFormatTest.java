/*
 * 创  建  人：rambo
 * 创建时间：2012-11-25
 */
package date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DataFormat测试
 * 
 * @author rambo
 * @since 2012-11-25
 */
public class DataFormatTest
{
    public static void main(String[] args)
    {
        Locale locale = Locale.ENGLISH;
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String now = df.format(new Date());
        System.out.println(now);
    }
}
