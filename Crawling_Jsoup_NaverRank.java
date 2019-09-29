package HbigAnalysisTest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling_Jsoup_NaverRank {
	
	static int j = 0;
	public static String text;

	public static void main(String[] args) throws IOException {
		
		//Jsoup 주요 요소
		//Document : Jsoup로 얻어온 결과 HTML 전체 문서
		//Element : Document의 HTML요소
		//Elements : Element 가 모인 자료형, for나 while등 반복문 사용이 가능함
		//Connection : Jsoup의 connect 혹은 설정 메소드들을 이용해 만들어지는 객체, 연결을 하기 위한 정보를 담고 있음
		//Response : Jsoup가 URL에 접속해 얻어온 결과

		Document doc = Jsoup.connect("https://www.naver.com/").get();
		
//		Elements titles = doc.select(".title");
		
//		for(Element e : titles) { // for(titles에 있는 객체를 꺼내서 e에다가 넣겠다 titles에 더이상 꺼낼 객체가 없을 때 까지)
//			
//			System.out.println("text : "+e.text());
//			System.out.println("html : "+e.html());
//			
//		}
		
		Elements SearchRankOfNaver = doc.select(".ah_k");
		
		System.out.println(SearchRankOfNaver);
		
		text = SearchRankOfNaver.select(".ah_k").html();
		
		System.out.println(text);
		
		
		
		
//		doc.select(".클래스 이름"); // 해당클래스 이름의 항목만 가져오기
//		doc.select("#id"); // 해당 이름의 아이디값만 가져오기
//		doc.select(".클래스명 태그"); // 해당클래스명의 태그만 파싱하기
//		doc.select(".클래스명") //select() : Elements반환, 결과 값이 1개일때 사용 
//		doc.select(".클래스명").get(0); // Elements반환, 파싱한 태그의 결과 값이 여러개일때 사용
		
	}
}
