package yanzhengma;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author gacl
 * �������˽��յ���֤���Ĵ���
 */
//@WebServlet("/servlet/CheckServlet")
public class CheckServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clientCheckcode = request.getParameter("validateCode");//���տͻ���������ύ��������֤��
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//�ӷ������˵�session��ȡ����֤��
        if (clientCheckcode.equals(serverCheckcode)) {//���ͻ�����֤��ͷ���������֤�Ƚϣ������ȣ����ʾ��֤ͨ��
            System.out.println("��֤����֤ͨ����");
        }else {
            System.out.println("��֤����֤ʧ�ܣ�");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}