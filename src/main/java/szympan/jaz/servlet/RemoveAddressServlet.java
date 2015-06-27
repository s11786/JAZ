package szympan.jaz.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import szympan.jaz.entity.Address;
import szympan.jaz.entity.User;
import szympan.jaz.jsp.JspName;
import szympan.jaz.jsp.JspUrlBuilder;
import szympan.jaz.parameter.context.ContextParameter;
import szympan.jaz.parameter.servlet.EntityParametr;
import szympan.jaz.parameter.servlet.UserParameter;
import szympan.jaz.repository.IAddressRepository;
import szympan.jaz.repository.IUserRepository;
import szympan.jaz.repository.unitofwork.IUnitOfWork;

@WebServlet("/RemoveAddressServlet")
public class RemoveAddressServlet extends HttpServlet {
    
    private IUnitOfWork unitOfWork;
    private IAddressRepository addressRepository;
    private IUserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoGet remove address servlet");
        initVariablesFromContext(req);
        String idString = (String) req.getParameter(EntityParametr.ID);
        int id = Integer.parseInt(idString);
        Address address = this.addressRepository.get(id);
        this.addressRepository.delete(address);
        User user = (User)req.getSession().getAttribute(UserParameter.USER);
        user.removeAddress(id);
        this.userRepository.update(user);
        this.unitOfWork.commit();
        resp.sendRedirect(JspUrlBuilder.build(JspName.SHOW_ALL_USER_ADDRESSES_JSP));
    }
    
    private void initVariablesFromContext(HttpServletRequest req) {
        ServletContext context = req.getServletContext();
        this.addressRepository = (IAddressRepository) context.getAttribute(ContextParameter.ADDRESS_REPOSITORY);
        this.userRepository = (IUserRepository) context.getAttribute(ContextParameter.USERS_REPOSITORY);
        this.unitOfWork = (IUnitOfWork) context.getAttribute(ContextParameter.UNIT_OF_WORK);
    }

}
