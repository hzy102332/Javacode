import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class simple {
	public static void main (String []args) throws IOException {
//		long a = 10^1000000;
//		
//		System.out.println(a);
//		
		URL url = new URL ("http://img88.010lm.com/img.php?https://image.uc.cn/s/wemedia/s/upload/2020/18313970b366e497338941a7bbba900c.png");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(1000);
		InputStream dis = conn.getInputStream();
		
		String filename  = "G:\\"+".png";	
		int length = 0;
		FileOutputStream fos = new FileOutputStream(new File(filename));
		byte [] buffer = new byte[1024*4];
		while ((length = dis.read(buffer))!=-1) {
			fos.write(buffer,0, length);
		}
		dis.close();
		fos.close();
		
		
	}

}
