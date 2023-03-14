package coma.web;

import coma.pojo.User;
import coma.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        username = URLEncoder.encode(username, "utf-8");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = service.login(username,password);

        if(user !=null){

            if("1".equals(remember)){

                Cookie cookie_username = new Cookie("username",username);
                Cookie cookie_password = new Cookie("password",password);
                cookie_password.setMaxAge(60*60*7*24);
                cookie_username.setMaxAge(60*60*7*24);
                response.addCookie(cookie_password);
                response.addCookie(cookie_username);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            System.out.println("contextpath:" + contextPath );
            response.sendRedirect(contextPath + "/SelectAllServlet");
        }else {
            request.setAttribute("login_msg","用户登陆失败");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
