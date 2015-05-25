import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;



public class HttpGetTest {
	public static void main(String argv[]) throws IOException, InterruptedException {
		
		
//	String proxy = "10.208.5.82";
//	String proxyPort = "2520";
//	String proxyUser = "anawc410";
//	String proxyPassword = "Ais#1114";
//			
//	URL url = null;
//	HttpURLConnection urlConn = null;
//	OutputStreamWriter outStreamWr = null;
//	HashMap responseHash = null;		
//	BufferedReader bufferReader = null;
//	String resultMsg = null;
//	String readMsg = null;		
//	String serviceType = null;
//	String endpoint = "http://localhost:8080/JerseyRest/dynamic/status.xml";
//	String webServiceParam = "";
//	String requestMethod = "GET";
//	url = new URL(endpoint);
//
//	
//	urlConn = (HttpURLConnection)url.openConnection();
//	urlConn.setRequestMethod(requestMethod);
//	urlConn.setConnectTimeout(30000);
//	urlConn.setReadTimeout(30000);				
//	urlConn.setDoInput(true);
//	urlConn.setDoOutput(true);
//	
//	urlConn.setRequestProperty("Host","127.0.0.1");
//	urlConn.setRequestProperty("CSP", "active");
//	urlConn.setRequestProperty("Accept","*/*");
//	urlConn.setRequestProperty("X-MSISDN","0889081799");
//	urlConn.setUseCaches (false);
//
//	
//	DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
//	
//	wr.writeBytes(webServiceParam);
//	wr.close ();
//	wr.flush();
//	
//	Thread.sleep(1000);
//	
//	if (urlConn.getResponseCode() != 200) {
//		throw new RuntimeException("Failed : HTTP error code : "
//				+ urlConn.getResponseCode());
//	}
//	
//	System.out.println("getResponseCode() : " + urlConn.getResponseCode());
//	System.out.println("getResponseMessage() : " + urlConn.getResponseMessage());
//	System.out.println("getContentType() : " + urlConn.getContentType());
//	
//	
//
//	
//    bufferReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
// 
//    while((readMsg = bufferReader.readLine()) != null){
//  		resultMsg += readMsg;
//  	}
//    
//	bufferReader.close();
//	System.out.println(resultMsg);
//	
//	urlConn.disconnect();

	
		String url = "http://127.0.0.1:8080/JerseyRest/dynamic/status.xml",

			       mobile = "0889081799";
		int port = 8080;
		
		
	
		URL server = new URL(url);
		Socket socket = new Socket("127.0.0.1",8080);
		Writer writer = new OutputStreamWriter(socket.getOutputStream(),
		                                       "UTF-8");
		

		writer.write("GET " + server.toExternalForm() + " HTTP/1.1\r\n");
		writer.write("Host: " + server.getHost() + "\r\n");
		writer.write("X-MSISDN:"+mobile+"\r\n");
		writer.write("Accept:*/*\r\n\r\n");


		
		writer.flush();
		Thread.sleep(500);
		BufferedInputStream bf = new BufferedInputStream(socket.getInputStream());
		System.out.println(bf.available());
		int n = 0;
		String output = "";
		byte[] buff = new byte[2048];
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		if (bf.available() > 0) {
			while ((n = bf.read(buff)) != -1) {
				output += new String(buff, 0, n);
				System.out.println(output);
				if (n < 2048)
					break;
			}
		}

	  
		writer.close();
		socket.close();
	
	}
	
	
}