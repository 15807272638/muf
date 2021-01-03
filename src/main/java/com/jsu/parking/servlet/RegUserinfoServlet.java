package com.jsu.parking.servlet;

import com.jsu.parking.db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/RegUserinfoAction")
public class RegUserinfoServlet extends HttpServlet {
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF8");
        PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String age=request.getParameter("age");
        String tel=request.getParameter("tel");

        DBManager dbm = new DBManager();
        //用户注册
        String sql = "insert into userinfo(name,pwd,age,tel,jine) values('"+name+"','"+pwd+"','"+age+"','"+tel+"','0')";

        Statement stat = null;
        Connection conn=null;
        try {
            conn=dbm.getConnection();
            stat = conn.createStatement();
            System.out.println(sql);
            stat.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(stat!=null)
                    stat.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        out.println("<script>alert('注册成功请登录！');window.location.href='login.jsp'</script>");
        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
}
