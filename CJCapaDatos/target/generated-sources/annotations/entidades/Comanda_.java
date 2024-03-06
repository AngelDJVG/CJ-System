package entidades;

import entidades.Movimiento;
import entidades.Producto;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-05T20:36:25", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comanda.class)
public class Comanda_ { 

    public static volatile SingularAttribute<Comanda, Calendar> fecha;
    public static volatile SingularAttribute<Comanda, Movimiento> movimiento;
    public static volatile SingularAttribute<Comanda, Boolean> estadoAbierta;
    public static volatile SingularAttribute<Comanda, Long> id;
    public static volatile ListAttribute<Comanda, Producto> productos;

}