package szympan.jaz.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import szympan.jaz.entity.Role;
import szympan.jaz.entity.User;
import szympan.jaz.jsp.JspName;
import szympan.jaz.jsp.JspUrlBuilder;
import szympan.jaz.parameter.servlet.UserParameter;

@WebFilter(JspName.GRANT_ROLE_JSP)
public class GrantPremiumRoleFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    System.out.println("Do premium filter");
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute(UserParameter.USER);
        if (user != null){ //&& Role.ADMIN == user.getRole()) {
            System.out.println("User admin login");
            chain.doFilter(request, response);
        } else {
            System.out.println("User has not admin role or not login");
            ((HttpServletResponse) response).sendRedirect(JspUrlBuilder.build(JspName.ACCESS_DENIED_JSP));
        }
    }

    @Override
    public void destroy() {
    }

}
