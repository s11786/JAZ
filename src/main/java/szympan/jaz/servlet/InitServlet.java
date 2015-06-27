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
import szympan.jaz.entity.builder.AddressBuilder;
import szympan.jaz.entity.builder.IEntityBuilder;
import szympan.jaz.entity.builder.UserBuilder;
import szympan.jaz.jsp.JspName;
import szympan.jaz.jsp.JspUrlBuilder;
import szympan.jaz.parameter.context.ContextParameter;
import szympan.jaz.repository.IAddressRepository;
import szympan.jaz.repository.IUserRepository;
import szympan.jaz.repository.dummy.DummyAddressRepository;
import szympan.jaz.repository.dummy.DummyUserRepository;
import szympan.jaz.repository.unitofwork.IUnitOfWork;
import szympan.jaz.repository.unitofwork.UnitOfWork;

@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IEntityBuilder<User> userBuilder= new UserBuilder();
        IUnitOfWork unitOfWork = new UnitOfWork();
        IUserRepository userRepository = new DummyUserRepository(userBuilder, unitOfWork);
        IEntityBuilder<Address> addressBuilder = new AddressBuilder();
        IAddressRepository addressRepository = new DummyAddressRepository(addressBuilder, unitOfWork);
        
        ServletContext context = req.getServletContext();
        context.setAttribute(ContextParameter.UNIT_OF_WORK, unitOfWork);
        context.setAttribute(ContextParameter.USERS_REPOSITORY, userRepository);
        context.setAttribute(ContextParameter.ADDRESS_REPOSITORY, addressRepository);
        
        resp.sendRedirect(JspUrlBuilder.build(JspName.DEFAULT_OPTIONS_JSP));
    }

}
