<%@page import="Model.SearchProductDAO"%>
<%@page import="Model.SearchProductDTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%
	session = request.getSession();
int run_check = (int) session.getAttribute("run_check");

request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();

//정녕 데이터 가져오는건 1068개가 한계인가? DB한번 오픈할때 수..
//네 아니네요. 전체 데이터값이 1068개뿐임 ㅅㄱ

System.out.print("searchClient_ok connect!");
if (run_check == 0) {
	ArrayList<SearchProductDTO> list = new ArrayList<SearchProductDTO>();
	SearchProductDAO dao = new SearchProductDAO();
	list = dao.first_allViewProduct();

	System.out.println("리스트 가져온 갯수:" + list.size());
	session.setAttribute("run_check", 1);

	Setting(list);
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).getProduct_title());
	}
}
%>
<%!//데이터베이스에 등록된 인기 연관 검색어라는 가정(실제로 쓸땐 DB연동해서 사용)

	ArrayList<String> my_keywordList = new ArrayList<String>();

	public void Setting(ArrayList<SearchProductDTO> dto) {
		//배열에 추가하기.
		for (int i = 0; i < dto.size(); i++) {
			//이걸 두번 넣어줘야한다니
			my_keywordList.add(dto.get(i).getProduct_title());
		}
	}

	//사용자가 입력한 단어의 연관 제시어 검색하여 리스트 반환
	public List<String> search(String userKeyword) {
		if (userKeyword == null || userKeyword.equals("")) {
			return null;
			//return Collections.EMPTY_LIST; 내장변수
		}
		//userKeyword = userKeyword.toUpperCase();//대문자검사
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < my_keywordList.size(); i++) {
			if (my_keywordList.get(i).startsWith(userKeyword)) {
				lists.add(my_keywordList.get(i));
				//중복처리완료!
				for (int j = 0; j < lists.size(); j++) {
					if (i == j) {
					} else if (my_keywordList.get(j).equals(my_keywordList.get(i))) {
						lists.remove(j);
					}
				}
			}
		}
		return lists;
	}%>

<%
	//파라미터를 읽어온 뒤 연관제시어 찾기
String userKeyword = request.getParameter("userKeyword");
List<String> keywordList = search(userKeyword);

//키워드갯수와 키워드단어들을 | 로 구분
out.print(keywordList.size());
out.print("|");
//출력형식 5 | abc,ajax,abc마트
Iterator<String> it = keywordList.iterator();
while (it.hasNext()) {
	String value = (String) it.next();
	out.print(value);
	if (keywordList.size() - 1 > 0) {
		out.print(",");//마지막단어에는 쉼표가 찍히지 않도록 size()-1번 반복
	}
}
%>