package utils;

import java.io.UnsupportedEncodingException;

public class StreamPrinter
{
    private static final int LENGTH_PER_LINE = 16;
    
    private static final String DEFAULT_CHARSET = "UTF-8";
    
    public static void Print(String str, String charset)
    {
        Print(str.getBytes(), charset);
    }
    
    public static void Print(String str)
    {
        Print(str.getBytes(), DEFAULT_CHARSET);
    }
    
    public static void Print(int[] bytes)
    {
        Print(bytes, DEFAULT_CHARSET);
    }
    
    public static void Print(byte[] bytes)
    {
        Print(bytes, DEFAULT_CHARSET);
    }
    
    public static void Print(byte[] bytes, String charset)
    {
        if (bytes == null)
        {
            System.out.println("null");
            return;
        }
        
        for (int offset = 0; offset < bytes.length; offset += LENGTH_PER_LINE)
        {
            int leaveLength = bytes.length - offset;
            int curLen = LENGTH_PER_LINE;
            if (leaveLength < LENGTH_PER_LINE)
            {
                curLen = leaveLength;
            }
            StringBuffer line = new StringBuffer();
            line.append(String.format("%04X   ", offset));
            for (int i = 0; i < curLen; i++)
            {
                line.append(String.format("%02X ", bytes[offset + i]));
            }
            
            while (line.length() < 56)
            {
                line.append(' ');
            }
            
            try
            {
                line.append(new String(new String(bytes, offset, curLen)
                        .getBytes(), charset));
            }
            catch (UnsupportedEncodingException e)
            {
                line.append(new String(bytes, offset, curLen));
            }
            
            System.out.println(line);
        }
    }
    
    public static void Print(int[] bytes, String charset)
    {
        if (bytes == null)
        {
            System.out.println("null");
            return;
        }
        
        for (int offset = 0; offset < bytes.length; offset += LENGTH_PER_LINE)
        {
            int leaveLength = bytes.length - offset;
            int curLen = LENGTH_PER_LINE;
            if (leaveLength < LENGTH_PER_LINE)
            {
                curLen = leaveLength;
            }
            StringBuffer line = new StringBuffer();
            line.append(String.format("%04X   ", offset));
            for (int i = 0; i < curLen; i++)
            {
                line.append(String.format("%02X ", bytes[offset + i]));
            }
            
            while (line.length() < 56)
            {
                line.append(' ');
            }
            
            try
            {
                line.append(new String(new String(bytes, offset, curLen)
                        .getBytes(), charset));
            }
            catch (UnsupportedEncodingException e)
            {
                line.append(new String(bytes, offset, curLen));
            }
            
            System.out.println(line);
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int[] bytes = { 0x00, 0x25, 0x86, 0x6a, 0xf6, 0x72, 0x00, 0x11, 0x5b,
                0x22, 0x29, 0xb6, 0x08, 0x00, 0x45, 0x00, 0x00, 0x42, 0xf2,
                0x90, 0x00, 0x00, 0x40, 0x11, 0x04, 0x64, 0xc0, 0xa8, 0x01,
                0x65, 0xc0, 0xa8, 0xa7, 0x43};
        StreamPrinter.Print(bytes);
        String str = "";
    }
}
