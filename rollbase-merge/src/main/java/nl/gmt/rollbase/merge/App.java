package nl.gmt.rollbase.merge;

import ch.qos.logback.classic.Level;
import nl.gmt.rollbase.logging.RedirectAppender;
import nl.gmt.rollbase.shared.RollbaseException;
import nl.gmt.rollbase.shared.RollbaseProject;
import nl.gmt.rollbase.shared.merge.JAXBUtils;
import nl.gmt.rollbase.shared.schema.Application;
import nl.gmt.rollbase.shared.schema.SchemaUtils;

import jakarta.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Main application class for the Rollbase merge tool.
 * This tool provides functions for integrating Rollbase into a version control system
 * by transforming Rollbase XML Application exports.
 */
public class App {
    public static void main(String[] args) {
        try {
            Arguments arguments = new Arguments(args);

            switch (arguments.getVerbosity()) {
                case INFO: 
                    RedirectAppender.setLevel(Level.INFO); 
                    break;
                case DEBUG: 
                    RedirectAppender.setLevel(Level.DEBUG); 
                    break;
                default:
                    // WARN is the default level
                    break;
            }

            switch (arguments.getMode()) {
                case LOAD: 
                    performLoad(arguments); 
                    break;
                case SAVE: 
                    performSave(arguments); 
                    break;
                default:
                    throw new IllegalArgumentException("Unknown mode: " + arguments.getMode());
            }
        } catch (ArgumentsException e) {
            System.err.println("Invalid arguments: " + e.getLocalizedMessage());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    private static void performLoad(Arguments arguments) throws RollbaseException, JAXBException, IOException, TransformerException {
        var application = new RollbaseProject(new File(arguments.getProject())).load();

        try (var os = new FileOutputStream(arguments.getFile())) {
            JAXBUtils.marshalFormatted(
                SchemaUtils.createMarshaller(),
                application,
                new StreamResult(os)
            );
        }
    }

    private static void performSave(Arguments arguments) throws RollbaseException, JAXBException {
        var application = (Application) SchemaUtils.createUnmarshaller()
            .unmarshal(new File(arguments.getFile()));

        new RollbaseProject(new File(arguments.getProject())).save(application);
    }
}
