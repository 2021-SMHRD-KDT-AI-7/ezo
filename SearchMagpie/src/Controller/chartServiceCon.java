package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chartServiceCon")
public class chartServiceCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB t_product�κ��� ��ǰ ������ seq ��ȣ�� �޾ƿ´�.
		//2. chartDAO�� getViewCount(seq��ȣ �Է�)
		//3. DTO�κ��� �ش� ��ǰ ī�װ�,�̸�,����,������ ������ �´�.
		//4. ������ �� ������ ��� ������
		
		//2021.11.18 10:45 ���� �ð� ��ǰ���� DB�� ���� ������ 
		//�� �� ���¶� ���� �����ϱ⿣ �ټ� �����
		
	}

}
