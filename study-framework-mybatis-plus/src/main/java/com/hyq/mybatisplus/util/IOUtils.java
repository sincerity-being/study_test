package com.hyq.mybatisplus.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * https://blog.csdn.net/qq_35981283/article/details/80021773
 * 从request 中获取body的数据 dubbo写法
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 15:15
 * @describe
 */
public class IOUtils {

    private static final int BUFFER_SIZE = 1024 * 8;

    /**
     * read string.
     *
     * @param reader Reader instance.
     * @return String.
     * @throws IOException
     */
    public static String read(Reader reader) throws IOException {
        StringWriter writer = new StringWriter();
        try {
            write(reader, writer);
            return writer.getBuffer().toString();
        }
        finally{ writer.close(); }
    }

    /**
     * write.
     *
     * @param reader Reader.
     * @param writer Writer.
     * @return count.
     * @throws IOException
     */
    public static long write(Reader reader, Writer writer) throws IOException{
        return write(reader, writer, BUFFER_SIZE);
    }

    /**
     * write.
     *
     * @param reader Reader.
     * @param writer Writer.
     * @param bufferSize buffer size.
     * @return count.
     * @throws IOException
     */
    public static long write(Reader reader, Writer writer, int bufferSize) throws IOException {
        int read;
        long total = 0;
        char[] buf = new char[BUFFER_SIZE];
        while( ( read = reader.read(buf) ) != -1 )
        {
            writer.write(buf, 0, read);
            total += read;
        }
        return total;
    }




}
