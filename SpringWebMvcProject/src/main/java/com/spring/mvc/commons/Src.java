package com.spring.mvc.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Src {
	
	// img태그, src태그 추출작업
	
	
	public static void main(String[] args) {
		
		String text = "<p>첫 번째</p>"
				+ "<img alt=\"\" src=\"/resources/images/noticeimg/6d451f33-7392-4136-9dfc-0c0e82a2773c1-2.jpg\" style=\"height:133px; width:200px\" />\r\n"
				+ "<p>두 번째</p>"
				+ "\r\n"
				+ "<img alt=\"\" src=\"/resources/images/noticeimg/3eec48ec-5c07-4ab6-a386-051159041bd5d4.jpg\" style=\"height:133px; width:200px\" />\r\n"
				+ "<p>세 번째</p>"
				+ "\r\n"
				+ "<img alt=\"\" src=\"/resources/images/noticeimg/94a8cbb1-d6a9-410f-8486-c18c608732a7d3.webp\" style=\"height:133px; width:200px\" />";	
		
		String imgReg = "(<img[^>]*src\s*=\s*[\"']?([^>\"\']+)[\"']?[^>]*>)";
		Pattern pattern = Pattern.compile(imgReg);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.println("img태그 전체 : " + matcher.group(1));
			System.out.println("src 내용만 : " + matcher.group(2));
		}
		
		
	}
}