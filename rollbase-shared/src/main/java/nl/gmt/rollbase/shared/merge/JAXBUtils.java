package nl.gmt.rollbase.shared.merge;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.util.JAXBSource;
import javax.xml.transform.*;

public class JAXBUtils {
    private JAXBUtils() {
    }

    public static void marshalFormatted(Marshaller marshaller, Object object, Result result) throws TransformerException, JAXBException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        transformer.transform(new JAXBSource(marshaller, object), result);
    }
}
