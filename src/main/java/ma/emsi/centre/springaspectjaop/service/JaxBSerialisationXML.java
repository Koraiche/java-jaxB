package ma.emsi.centre.springaspectjaop.service;


import ma.emsi.centre.springaspectjaop.domain.Compte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class JaxBSerialisationXML {
    public static void Serialisation(Compte compte) {
        try {
            JAXBContext context = JAXBContext.newInstance(Compte.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(compte, new File("src/main/resources/comptes.xml"));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
    public static Compte Deserialisation(String path) {
        Logger log = LoggerFactory.getLogger(JaxBSerialisationXML.class);
        try {
            JAXBContext context = JAXBContext.newInstance(Compte.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Compte compte = (Compte) unmarshaller.unmarshal(new File(path));
            log.info("Unmarshall compte : {}", compte);
            return compte;
        }catch (JAXBException e){
            e.printStackTrace();
            return null;
        }
    }
}
