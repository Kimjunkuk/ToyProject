package HbigAnalysisTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CrawlingBufferedReaderType {

	public static void main(String[] args) throws IOException {

		URL url = new URL("https://www.naver.com/");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		
		String line; 
		
		int check_line =0;
		
		System.out.println("url:"+url);
		
		System.out.println("reader입니다 : "+reader);
		
		while((line = reader.readLine()) != null) {
			
//			System.out.println("reader.readLine() 함수 : "+reader.readLine());
			
//			System.out.println("line 입니다 : "+line);
//			String[] temp = line.split("<a>");
//			System.out.println(temp);
//
//
////						.split("<")[0]

//				temp = temp.trim();

//				System.out.println(temp);
//			}
//			if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd")) {
//				//contains()메서드는 특정 문자열이 포함되어 있는지 확인하는 기능을 한다.
//				check_line = 1;
//			}
//			if(line.contains("<a href=\"/marketindex/?tabSel=worldExchange#tab_sectionn\"")) {
//				check_line = 0;
//			}
//			if(check_line ==1) {
				
//				if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd=")) {
//					
//					String temp = line.split(">")[2].split("<")[0];
//					
//					temp = temp.trim();
//					
////					System.out.println(temp);
//				}
//				
//				if(line.contains("<td>") && !line.contains("em")) {
//					
//					String temp = line.split(">")[1].split("<")[0];
//					
////					System.out.println(temp);
//				}
//				
//				if(line.contains("<td>") && line.contains("em")) {
//					
//					String temp = line.split(">")[5].split("<")[0];
//					
////					System.out.println(temp);
//					
//					String temp2 = line.split(">")[5].split("<")[0];
//					
////					System.out.println(temp2);
//					
//
//				}
//			}

		}
		reader.close();
		
	}

}



