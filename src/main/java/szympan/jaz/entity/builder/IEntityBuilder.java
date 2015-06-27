package szympan.jaz.entity.builder;

import javax.servlet.http.HttpServletRequest;
import szympan.jaz.entity.Entity;
import szympan.jaz.entity.EntityState;

public interface IEntityBuilder <TEntity extends Entity> {
    
    public TEntity build(HttpServletRequest request);
    
    public TEntity build(TEntity entity);
    
}
