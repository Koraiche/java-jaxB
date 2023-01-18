package ma.emsi.centre.springaspectjaop;

import lombok.extern.slf4j.Slf4j;
import ma.emsi.centre.springaspectjaop.domain.Client;
import ma.emsi.centre.springaspectjaop.domain.Compte;
import ma.emsi.centre.springaspectjaop.service.JaxBUtilsXML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBException;
import java.util.Date;


@SpringBootApplication @Slf4j
public class SpringAOPApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringAOPApplication.class, args);
	}

	@Override
	public void run(String... args) throws JAXBException {
		Compte cp = new Compte(1L, 7000, new Date(), true, "123456","Crédit", new Client(10, "Fahd"));
		JaxBUtilsXML.Serialisation(cp);
		JaxBUtilsXML.Deserialisation("src/main/resources/comptes.xml");
		JaxBUtilsXML.GenerateSchema();

	}
}
