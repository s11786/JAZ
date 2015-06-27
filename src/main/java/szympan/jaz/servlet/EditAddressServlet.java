package szympan.jaz.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import szympan.jaz.entity.Address;
import szympan.jaz.entity.builder.AddressBuilder;
import szympan.jaz.entity.builder.IEntityBuilder;
import szympan.jaz.jsp.JspName;
import szympan.jaz.jsp.JspUrlBuilder;
import szympan.jaz.parameter.context.ContextParameter;
import szympan.jaz.parameter.servlet.EntityParametr;
import szympan.jaz.repository.IAddressRepository;
import szympan.jaz.repository.unitofwork.IUnitOfWork;

@WebServlet("/EditAddressServlet")
public class EditAddressServlet extends HttpServlet {
    
    private IEntityBuilder<Address> builder;
    private IUnitOfWork unitOfWork;
    private IAddressRepository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoGet edit address servlet");
        initVariablesFromContext(req);
        String idString = (String) req.getParameter(EntityParametr.ID);
        int id = Integer.parseInt(idString);
        Address address = this.builder.build(req);
        address.setId(id);
        this.repository.update(address);
        this.unitOfWork.commit();
        resp.sendRedirect(JspUrlBuilder.build(JspName.SHOW_ALL_USER_ADDRESSES_JSP));
    }
    
    private void initVariablesFromContext(HttpServletRequest req) {
        ServletContext context = req.getServletContext();
        this.repository = (IAddressRepository) context.getAttribute(ContextParameter.ADDRESS_REPOSITORY);
        this.unitOfWork = (IUnitOfWork) context.getAttribute(ContextParameter.UNIT_OF_WORK);
        this.builder = new AddressBuilder();
    }

}
