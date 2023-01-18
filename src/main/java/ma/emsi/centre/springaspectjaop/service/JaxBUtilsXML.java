package ma.emsi.centre.springaspectjaop.service;


import ma.emsi.centre.springaspectjaop.domain.Compte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class JaxBUtilsXML {
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
        Logger log = LoggerFactory.getLogger(JaxBUtilsXML.class);
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
    public static void GenerateSchemaFromClass() {
        try {
            JAXBContext context = JAXBContext.newInstance(Compte.class);
            context.generateSchema(new SchemaOutputResolver() {
                @Override
                public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                    File file = new File("src/main/resources/schemas/comptes.xsd");
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.getName());
                    return result;
                }
            });
        }catch (JAXBException | IOException e){
            e.printStackTrace();
        }
    }
    public static void GenerateClassFromSchema() {
        try {
            JAXBContext context = JAXBContext.newInstance(Compte.class);
            context.generateSchema(new SchemaOutputResolver() {
                @Override
                public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                    File file = new File("src/main/resources/schemas/comptes.xsd");
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.getName());
                    return result;
                }
            });
        }catch (JAXBException | IOException e){
            e.printStackTrace();
        }
    }
}
