package ma.emsi.centre.springaspectjaop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name="client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements Serializable {
    private int codeClient;
    private String nomClient;
}
