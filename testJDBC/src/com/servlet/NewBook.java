package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newBook")
public class NewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8"); //�ѱۼ���?
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//�ǹ������� ������ ���̽���IP��PORT��ȣ�� ����.
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null; //��Ű� ������ ����� ��ü ����
		Statement stmt = null;
		
		try {//������ �����ϱ� ������ ������ ���� ���� �������� �ݵ�� ���ܹ��� �ۼ��ؾ���
			Class.forName(driver);//oracleDirver�ε�
			
			con = DriverManager.getConnection(url, id, pw); //�����ͺ��̽� ��ġ ����ID ��й�ȣ 3���� ������ �����ָ� connection��
			stmt = con.createStatement();//��Ű�ü ����
			String sql = "INSERT INTO book(book_id, book_name, book_loc)";//query�� �ۼ�
					sql += " VALUES (BOOK_SEQ.NEXTVAL, '" + bookName + "', '" + bookLoc + "')";
			int result = stmt.executeUpdate(sql);//��Ű�üstmt�� �̿��Ͽ� query���� �����Ѵ�.
			
			if(result == 1) {//query�� ���� ����
				out.print("INSERT success!!");
				//������ ��� �����ϰ� ����Ʈ�� ���ų� ���ο� ����� ���� �� ���ִ� â �����
				response.sendRedirect("Select.jsp");
			} else {//����
				out.print("INSERT fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//�ݵ�� ������� �ڿ��� ����ϸ� �ݵ�� ����������Ѵ�.
						try { 
				if(stmt != null) stmt.close();//������ �������� stmt���� ����(�ڿ��� ��ȯ�ϴ� ����)
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
