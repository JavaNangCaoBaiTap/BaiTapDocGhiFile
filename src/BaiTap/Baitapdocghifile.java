package BaiTap;
import java.io.*;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Baitapdocghifile {
	 static String FILEPATH = ""; 
	    static File file = new File(FILEPATH); 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//	    String str1 = readByline("E:\\JavaNangCao\\BaiTapDocGhiFile\\ca-dao.txt");
//        System.out.println(str1);
//
//        String str2 = readUTF8("E:\\\\JavaNangCao\\\\BaiTapDocGhiFile\\\\ca-dao.txt");
//        System.out.println(str2);
		
//		  String str1 = readBuffer("D:\\Java-nang-cao\\learning-java\\resources\\ca-dao.txt");
//	        System.out.println(str1);

//	        String str2 = readBuffer("E:\\\\JavaNangCao\\\\BaiTapDocGhiFile\\\\ca-dao.txt");
//	        System.out.println(str2);
//		
//	        String string = "GeeksForGeeks"
//                    + " - A Computer Science"
//                    + " Portal for geeks"; 
//	        String hinhmeo="https://vtv1.mediacdn.vn/thumb_w/650/2016/3-hfhe-1479699786108.jpg";
	        // Get byte array from string 
	       byte[] str3 = readImage("https://vtv1.mediacdn.vn/thumb_w/650/2016/3-hfhe-1479699786108.jpg");
	       // byte [] data =readOnlineResource("https://vtv1.mediacdn.vn/thumb_w/650/2016/3-hfhe-1479699786108.jpg");
	     // byte[] bytes = str3.getBytes(); 

    // Convert byte array to file 
    saveFile("E:\\meo.jpg",str3); 
	}
	
	public static String read(String filename) throws IOException 
	{
		String str="";
		InputStream is = new FileInputStream(filename);
		int c;
		while((c=is.read())!=-1)
		{
			str+=(char)c;
		}
		is.close();
		return str;
	}
	
	public static String readUTF8(String filename) throws IOException
	{
		String str="";
		Reader is = new FileReader(filename);
		int c;
		while((c=is.read())!=-1)
		{
			str+=(char)c;
		}
		
		is.close();
		return str;
	}
	
	public static String readByline(String filename) throws IOException{
		String str="";
		Reader reader = new FileReader(filename);
		BufferedReader br = new BufferedReader(reader);
		String line;
		while((line = br.readLine())!=null) {
			str += line +'\n'; 
		}
		return str;

	}
	
	public static String readBuffer(String filename) throws IOException {

        String str = null;
        // 0123456789
        byte[] buffer = new byte[10]; //[0][1][2]

        InputStream is = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int count;
        while ((count = bis.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        str = new String(baos.toByteArray());
        baos.close();
        is.close();

        return str;
    }
	
	 // https://raw.githubusercontent.com/nam-long/learning-java/master/resources/ca-dao.txt
    public static byte[] readImage(String strUrl) throws IOException {

        byte[] str = null;

        URL url = new URL(strUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1000];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            str = baos.toByteArray();

            is.close();
        }

        return str;
    }
    
    public static String readOnlineResource(String strUrl) throws IOException {

        String str = null;

        URL url = new URL(strUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1000];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            str = new String(baos.toByteArray());

            is.close();
        }

        return str;
    }
	
	
	public static void saveFile(String filename,byte[] data)
	{
		 try { 
			  
	            // Initialize a pointer 
	            // in file using OutputStream 
	            OutputStream 
	                os = new FileOutputStream(filename); 
	  
	            // Starts writing the bytes in it 
	            os.write(data); 
	            System.out.println("Successfully"
	                               + " byte inserted"); 
	  
	            // Close the file 
	            os.close(); 
	        } 
	  
	        catch (Exception e) { 
	            System.out.println("Exception: " + e); 
	        } 
	}
}
