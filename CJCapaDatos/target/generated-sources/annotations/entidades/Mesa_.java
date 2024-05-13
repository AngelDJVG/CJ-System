package entidades;

import entidades.ComandaMesa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-13T16:49:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Mesa.class)
public class Mesa_ { 

    public static volatile SingularAttribute<Mesa, Long> numero;
    public static volatile ListAttribute<Mesa, ComandaMesa> comandas;

}