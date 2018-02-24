/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年5月3日
 */
package QRCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @author ywb
 * @version $Id: TestCode.java,v 0.1 2017年5月3日 下午2:29:12 Administrator Exp $
 */
public class TestCode {
	
	@Test
	public void test(){
		
		
		
		ArrayList<Object> ar=new ArrayList<Object>();
		Map<String, Object> b=new HashMap<String, Object>();
		b.put("one", 21);
		b.put("two", 22);
		b.put("three", 23);
		ar.add(b);
		
		ArrayList a=new ArrayList();
		JSONObject bb=new JSONObject();
		bb.put("ss", 4343);
        a.add(bb);
        Map tt=(Map) ar.get(0);
        
        Set<Integer> s=new HashSet<Integer>();
        s.add(null);
        s.add(22);
        s.add(12);
        
        List<test> l=new ArrayList<test>();
        test te=new test();
        te.setId((long) 11);
        te.setName("qyh");
        te.setPassword((long) 22222);
        l.add(te);
        te.setId((long) 111);
        te.setName("qyh2");
        te.setPassword((long) 222224);
       
        l.add(te);
        JSONArray array=new JSONArray();
        JSONObject ob=new JSONObject();
        array=JSONArray.fromObject(l);
        ob=(JSONObject) array.get(0);
        System.out.println(ob.get("id"));
        System.out.println(l.get(0).name);
//        for(Iterator it=s.iterator();it.hasNext();){
//        	Integer sd=(Integer) it.next();
//        System.out.println(sd);}
	}
    @Test
    public void testEndode() throws WriterException, IOException {
        String filePath = "D://";
        String url = "http://www.baidu.com";
        String fileName = "code.png";
        int width = 200;
        int height = 200;
        String format = "png";
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bit = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bit, format, path);
    }

    @Test
    public void testJSoup() {
        String host = "mp.weixin.qq.com";
        String url = "http://mp.weixin.qq.com/s/Q3Nik3wmYempyQfaf4jdHw";
        Response res;
        try {
            res = Jsoup
                .connect(url)
                .userAgent(
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0")
                .timeout(60 * 1000).execute();

            Document doc = Jsoup.parse(res.body());
            final Elements img = doc.select("img[data-src]");
            final Map<String, File> imgMap = new HashMap<String, File>();
            ExecutorService te = Executors.newFixedThreadPool(5);
            List<File> imgs = new ArrayList<File>();
            final AtomicInteger index = new AtomicInteger(0);
            for (final Element element : img) {
                element.attr("src", element.attr("data-src"));
                te.execute(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            downIMG(element);
                            index.getAndAdd(1);
                        } catch (IOException e1) {

                        }
                    }

                    /**
                     * @param element
                     * @throws MalformedURLException
                     * @throws IOException
                     * @throws FileNotFoundException
                     */
                    private void downIMG(final Element element) throws MalformedURLException,
                                                               IOException, FileNotFoundException {
                        URL u = new URL(element.attr("data-src"));
                        HttpURLConnection hc = (HttpURLConnection) u.openConnection();
                        hc.setConnectTimeout(60000);
                        InputStream is = hc.getInputStream();
                        File imgg = new File("D://" + (index)+ ".jpg");
                        FileOutputStream fos = new FileOutputStream(imgg);
                        byte[] by = new byte[1024];
                        int len = -1;
                        while ((len = is.read(by)) != -1) {
                            fos.write(by, 0, len);
                        }
                        fos.close();
                        is.close();
                        imgMap.put(element.attr("data-src"), imgg);
                    }
                });
            }
            
            if (te.isTerminated()) {
                te.shutdown();
            }

            //                element.attr("src", element.attr("data-src"));
            //            }

            File f = new File("D://T.html");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), res.charset());
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(doc.html());
            bw.close();
            osw.close();
            Thread.sleep(5000);
        } catch (IOException e) {

        } catch (InterruptedException e) {
        }
    }
}
