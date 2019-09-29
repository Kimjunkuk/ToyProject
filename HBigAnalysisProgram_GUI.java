package HbigAnalysisTest;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HBigAnalysisProgram_GUI extends JFrame {

	int i=0;
	String text="";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTime;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					HBigAnalysisProgram_GUI frame = new HBigAnalysisProgram_GUI();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HBigAnalysisProgram_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHtml = new JLabel("버튼을 누르면 버튼에 해당하는 자료를 크롤링 하는 프로그램입니다");
		lblHtml.setBounds(31, 37, 394, 14);
		contentPane.add(lblHtml);
		
		//결과 출력창
		JLabel label = new JLabel("현제 시간 : ");
		label.setBounds(31, 169, 117, 14);
		contentPane.add(label);
		
		textTime = new JTextField();
		textTime.setBounds(94, 166, 274, 20);
		contentPane.add(textTime);
		textTime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("결과 내용 :");
		lblNewLabel.setBounds(31, 194, 64, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(1);
		textArea.setRows(50);
		textArea.setBounds(31, 219, 567, 690);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("실시간 인기검색어(naver)");
		btnNewButton.setBounds(31, 62, 212, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent start) {
				
				try {
					
					Document doc = Jsoup.connect("https://www.naver.com/").get(); //jsoup 라이브러리 이용 하여 url로 부터 HTML 가져옴
					
					//** Elements만 for문 while문 사용 가능 **
					
					Elements SearchRankOfNaver = doc.select(".ah_k"); // Elements SearchRankOfNaver에 가져온 HTML중에서 ah_k라는 이름의 class만 추출하여 저장한다
					
					for(Element data : SearchRankOfNaver) { //(Element data에 : SearchRankOfNaver에 저장된 내용을 전부 다 담을때 까지 반복 한다 )
						i++;
						text+=i+data.select(".ah_k").html()+"\n"; //메소드 변수에 선언된 text String 변수에 Element에 1씩 증가한 숫자를 더해주며 자료를 전부 담을때까지 + <=추가한다
						
					}
					
					System.out.println(text); //String 전역변수에 담겨진 크롤링 내용 확인
					textArea.setText(text); //결과 화면창으로 송부함
					
					Date today = new Date();  //크롤링 시간 
					String nowtime = today.toString();
					
					textTime.setText(nowtime);
					
					
				}
				catch(Exception e){
					System.out.println(e);
				}

			}
		});
		
		JButton btnNewButton_1 = new JButton("CSV로 저장");
		btnNewButton_1.setBounds(31, 96, 117, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent start) {
				
				String enc = new java.io.OutputStreamWriter(System.out).getEncoding();
				System.out.println("현재 인코딩 : "+ enc);
				
				String head = "네이버 실시간 RANK";
				String firstRow = text;
				String secondRow = "";
				
				try {
					
					String csvFileName = "D:/naverRank.csv";
					
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFileName), "UTF-8"));
					
					writer.write(head);
					writer.write(firstRow);
					writer.write(secondRow);
					writer.close();




				}
				catch(Exception e){
					System.out.println(e);
				}

			}
		});

	}
}
