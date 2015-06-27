package szympan.jaz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import szympan.jaz.entity.Role;
import szympan.jaz.entity.User;
import szympan.jaz.parameter.context.ContextParameter;
import szympan.jaz.parameter.servlet.UserParameter;
import szympan.jaz.repository.IUserRepository;
import szympan.jaz.repository.unitofwork.IUnitOfWork;

@WebServlet("/GrantRoleServlet")
public class GrantRoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserRepository repository
                = (IUserRepository) req.getServletContext().getAttribute(ContextParameter.USERS_REPOSITORY);
        String userName = (String) req.getParameter(UserParameter.NAME);
        String roleName = (String) req.getParameter(UserParameter.ROLE);
        System.out.println(userName+" "+roleName);
        User user = repository.get(userName);
        System.out.println(user);
        if (user != null) {
            user.setRole(Enum.valueOf(Role.class, roleName));
            IUnitOfWork unitOfWork
                    = (IUnitOfWork) req.getServletContext().getAttribute(ContextParameter.UNIT_OF_WORK);
            repository.update(user);
            unitOfWork.commit();
        }
    }

}
