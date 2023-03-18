package coma.web.filter;

import coma.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String[] urls = {"/login.jsp","/CheckCodeServlet","/LoginServlet","/RegisterServlet",
                "/register.jsp", "/imgs/","/css/","/ajaxDemo.html","/AjaxServlet","/register.html","/SelectUserServlet"
                ,"/axiosDemo.html","/AxiosServlet","/axios-demo.html","/jss/"};
        String url = req.getRequestURI().toString();

        for(String u: urls){
            if(url.contains(u)){
                chain.doFilter(request,response);
                return;
            }
        }

        if(user!=null) {
            chain.doFilter(request, response);
        }else{
            req.setAttribute("login_msg","尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }
}
