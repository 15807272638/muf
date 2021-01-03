package com.jsu.parking.servlet;

import com.jsu.parking.db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        this.doPost(request, response);
        out.close();
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to
     * post.
     *
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF8");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String type = request.getParameter("type");

        DBManager dbm = new DBManager();


        request.getSession().setAttribute("fei", dbm.getSF());

        if (type.equals("用户")) {
            int uid = dbm.loginYH(username, userpwd);
            if (uid > 0) {
                request.getSession().setAttribute("user", username);
                request.getSession().setAttribute("uid", uid + "");
                request.getSession().setAttribute("type", "用户");
                response.sendRedirect("index.jsp");

            } else {
                out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
            }


        } else if (type.equals("管理员")) {
            boolean login = dbm.login(username, userpwd);
            System.out.println(login);
            if (login) {
                request.getSession().setAttribute("user", username);
                request.getSession().setAttribute("type", "管理员");
                response.sendRedirect("index.jsp");

            } else {
                out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
            }
        } else {
            out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
}
