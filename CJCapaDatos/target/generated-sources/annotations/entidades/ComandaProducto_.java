package entidades;

import entidades.Comanda;
import entidades.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-18T13:29:43", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ComandaProducto.class)
public class ComandaProducto_ { 

    public static volatile SingularAttribute<ComandaProducto, Double> total;
    public static volatile SingularAttribute<ComandaProducto, String> detalles;
    public static volatile SingularAttribute<ComandaProducto, Long> id;
    public static volatile SingularAttribute<ComandaProducto, Comanda> comanda;
    public static volatile SingularAttribute<ComandaProducto, Producto> producto;
    public static volatile SingularAttribute<ComandaProducto, Integer> cantidad;
    public static volatile SingularAttribute<ComandaProducto, Double> precioVenta;

}