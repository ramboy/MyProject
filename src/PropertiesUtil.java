import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 实现任意properties文件读写 支持各种字符集 2006-5-16
 * 
 * @author 廖海辉
 */
public class PropertiesUtil extends ArrayList
{
    private static final long serialVersionUID = 1L;

    // 设置字符集
    private String encoding = "GBK";

    private String fileName;

    @SuppressWarnings("unchecked")
    public PropertiesUtil(String fileName, String encoding)
    {
        try
        {
            // super(Arrays.asList(read(fileName, encoding).split("\n")));
            this.setFileName(fileName);
            this.setCharacterEncoding(encoding);
            if (!isFileExist(fileName))
                this.write("");
            this.addAll(Arrays.asList(read(fileName, encoding).split("\n")));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * 设置字符集
     * 
     * @param encoding
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings("unused")
    private void setCharacterEncoding(String encoding) throws UnsupportedEncodingException
    {
        // Test the encoding is valid
        new String("".getBytes("iso8859_1"), encoding);
        // Getting here means we're valid, so set the encoding
        this.encoding = encoding;
    }

    public static boolean isFileExist(String fileName)
    {
        return new File(fileName).isFile();
    }

    /**
     * read file as single strings
     * 
     * @return
     * @throws IOException
     */
    public static String read(String fileName, String encoding) throws IOException
    {
        StringBuffer sb = new StringBuffer();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = in.readLine()) != null)
        {
            // 为什么转换了反而会是乱码
            sb.append(s);// new String(s.getBytes("iso8859_1"), encoding));
            sb.append("\n");
        }
        in.close();
        return sb.toString();
    }

    /**
     * write file as single strings
     * 
     * @param text
     * @throws IOException
     */
    public void write(String text) throws IOException
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        out.print(text);
        out.close();
    }

    /**
     * save the content to file
     * 
     * @throws IOException
     */
    public void save() throws IOException
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        String tmp;
        for (int i = 0; i < size(); i++)
        {
            tmp = get(i) + "";
            // tmp = new String(tmp.getBytes("iso8859_1"),encoding);
            out.println(tmp);
        }
        out.close();
    }

    /**
     * set properties file with a par key and value
     * 
     * @param key
     * @param val
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings("unchecked")
    public void setProperties(String key, String val)
    {
        int ipos = findKey(key);
        if (ipos >= 0)
            this.set(ipos, key + "=" + val);
        else
            this.add(key + "=" + val);
    }

    /**
     * 查找KEY的序号
     * 
     * @param key
     * @return
     */
    public int findKey(String key)
    {
        try
        {
            String tmp;
            for (int i = 0; i < size(); i++)
            {
                tmp = get(i) + "";
                tmp = new String(tmp.getBytes("iso8859_1"), encoding);
                if (tmp.indexOf(key) == 0)
                {
                    return i;
                }
            }
        }
        catch (Exception e)
        {
        }
        return -1;
    }

    /**
     * 增加备注
     * 
     * @param memo
     */
    @SuppressWarnings("unchecked")
    public void setMemo(String key, String memo)
    {
        if ("".equals(key))
        {
            this.add("#" + memo);
            return;
        }
        String tmp;
        int ret = findKey(key);
        if (ret == -1)
        {// 如果没有找到
            this.add("#" + memo);
            this.add(key + "=");
        }
        else
        {
            int ipos = ret - 1;
            if (ipos < 0)
                this.add(ipos, "#" + memo);
            else
            {
                tmp = this.get(ipos) + "";
                if ("#".equals(tmp.substring(0, 1)))
                    this.set(ipos, "#" + memo);
                else
                    this.add(ipos + 1, "#" + memo);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void setTitle(String title)
    {
        String tmp = this.get(0) + "";
        if (tmp == null || tmp.length() == 0)
            tmp = "";
        else
            tmp = tmp.substring(0, 1);

        if ("#".equals(tmp))
            this.set(0, "#" + title);
        else
        {
            this.add(0, "");
            this.add(0, "#" + title);
        }
    }

    /**
     * get the value of a key
     * 
     * @param key
     * @return
     */
    public String getProperties(String key)
    {
        return getProperties(key, "");
    }

    public String getProperties(String key, String defaultStr)
    {
        String tmp, ret;
        try
        {
            for (int i = 0; i < size(); i++)
            {
                tmp = get(i) + "";
                tmp = new String(tmp.getBytes("iso8859_1"), encoding);
                if (tmp.indexOf(key) == 0)
                {
                    ret = tmp.substring(key.length() + 1);
                    return ret;
                }
            }
        }
        catch (Exception e)
        {
        }
        return defaultStr;
    }

    public String getFileName()
    {
        return fileName;
    }

    private void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    // Simple test:
    public static void main(String[] args) throws Exception
    {
        String path = "E:\\test2.properties";
        PropertiesUtil pro = new PropertiesUtil(path, "utf-8");
        pro.setProperties("WebSiteName", "江西省水利厅");
        pro.setProperties("must", "1");
        pro.setProperties("hehe", "it's so simple");
        pro.save();
        // System.out.println(pro.read());
        pro = null;
    }

} // /:~
