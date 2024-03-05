package entidades;

import entidades.Cliente;
import entidades.Comanda;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-04T19:53:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Calendar> fecha;
    public static volatile SingularAttribute<Movimiento, Cliente> cliente;
    public static volatile SingularAttribute<Movimiento, String> tipo;
    public static volatile SingularAttribute<Movimiento, Long> id;
    public static volatile SingularAttribute<Movimiento, Comanda> comanda;

}