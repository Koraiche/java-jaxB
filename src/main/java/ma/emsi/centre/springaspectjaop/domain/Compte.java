package ma.emsi.centre.springaspectjaop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@XmlRootElement(name="compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte implements Serializable {
    @XmlElement
    private Long code;
    @XmlElement
    private double solde;
    @XmlElement
    private Date dateCreation;
    @XmlElement
    private boolean active;
    @XmlTransient
    private String mdp;
    @XmlAttribute
    private String sens;
    @XmlElement
    private Client client;
}
