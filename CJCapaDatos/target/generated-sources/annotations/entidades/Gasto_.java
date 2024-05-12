package entidades;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T12:48:36", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Gasto.class)
public class Gasto_ { 

    public static volatile SingularAttribute<Gasto, String> descripcion;
    public static volatile SingularAttribute<Gasto, Calendar> fecha;
    public static volatile SingularAttribute<Gasto, Double> total;
    public static volatile SingularAttribute<Gasto, Long> id;

}