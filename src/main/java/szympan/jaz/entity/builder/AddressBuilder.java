package szympan.jaz.entity.builder;

import javax.servlet.http.HttpServletRequest;
import szympan.jaz.entity.Address;
import szympan.jaz.entity.AddressType;
import szympan.jaz.entity.EntityState;
import szympan.jaz.entity.Province;
import szympan.jaz.parameter.servlet.AddressParameter;
import szympan.jaz.util.AddressPoolOfIds;

public class AddressBuilder implements IEntityBuilder<Address> {

    @Override
    public Address build(HttpServletRequest request) {
        String addressTypeString = request.getParameter(AddressParameter.ADDRESS_TYPE);
        AddressType addressType = Enum.valueOf(AddressType.class, addressTypeString);
        String city = request.getParameter(AddressParameter.CITY);
        String nrOfApartment = request.getParameter(AddressParameter.NUMBER_OF_APARTMENT);
        String postCode = request.getParameter(AddressParameter.POSTCODE);
        String provinceString = request.getParameter(AddressParameter.PROVINCE);
        Province province = Enum.valueOf(Province.class, provinceString);
        String street = request.getParameter(AddressParameter.STREET);
        return createAddress(addressType, city, nrOfApartment, postCode, province, 
                street, AddressPoolOfIds.generateId(), EntityState.NEW);
    }
    
    @Override
    public Address build(Address entity) {
         AddressType addressType = entity.getAddressType();
        String city = entity.getCity();
        String nrOfApartment = entity.getNrOfApartament();
        String postCode = entity.getPostCode();
        Province province = entity.getProvince();
        String street = entity.getStreet();
        int id = entity.getId();
        EntityState entityState = entity.getEntityState();
        return createAddress(addressType, city, nrOfApartment, postCode, 
                province, street, id, entityState);
    }
    
      private Address createAddress(AddressType addressType, String city, 
              String nrOfApartment, String postCode, Province province,
            String street, int id, EntityState entityState){
        Address address = new Address();
        address.setAddressType(addressType);
        address.setCity(city);
        address.setNrOfApartament(nrOfApartment);
        address.setPostCode(postCode);
        address.setProvince(province);
        address.setStreet(street);
        address.setId(id);
        address.setEntityState(entityState);
        return address;
    }

}
