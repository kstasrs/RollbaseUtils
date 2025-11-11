package nl.gmt.rollbase.merge;

/**
 * Parses and stores command-line arguments for the Rollbase merge tool.
 * <p>
 * This class handles two primary commands:
 * <ul>
 *   <li><b>load</b> - Loads a Rollbase project and creates an XML export
 *       <br>Usage: {@code load -p <project_dir> -t <target_file> [-v|-vv]}
 *   </li>
 *   <li><b>save</b> - Saves an XML export into the version control repository
 *       <br>Usage: {@code save -p <project_dir> -s <source_file> [-v|-vv]}
 *   </li>
 * </ul>
 * <p>
 * Common options:
 * <ul>
 *   <li>{@code -p <path>} - Project directory (required)</li>
 *   <li>{@code -t <path>} - Target file for load command</li>
 *   <li>{@code -s <path>} - Source file for save command</li>
 *   <li>{@code -v} - Verbose mode (INFO level)</li>
 *   <li>{@code -vv} - Very verbose mode (DEBUG level)</li>
 * </ul>
 * 
 * @author Rollbase Utils Contributors
 * @since 0.1
 */
public class Arguments {
    private Mode mode;
    private String project;
    private String file;
    private Verbosity verbosity = Verbosity.WARN;

    /**
     * Constructs and parses command-line arguments.
     *
     * @param args the command-line arguments to parse
     * @throws ArgumentsException if the arguments are invalid or incomplete
     */
    public Arguments(String[] args) throws ArgumentsException {
        if (args.length < 1) {
            throw new ArgumentsException("Expected 'load' or 'save' as the first argument");
        }

        switch (args[0]) {
            case "load" -> parseLoadArguments(args);
            case "save" -> parseSaveArguments(args);
            default -> throw unexpectedArgument(args[0]);
        }
    }

    /**
     * Gets the operation mode (LOAD or SAVE).
     *
     * @return the mode
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Gets the project directory path.
     *
     * @return the project directory path
     */
    public String getProject() {
        return project;
    }

    /**
     * Gets the file path (source or target depending on mode).
     *
     * @return the file path
     */
    public String getFile() {
        return file;
    }

    /**
     * Gets the logging verbosity level.
     *
     * @return the verbosity level
     */
    public Verbosity getVerbosity() {
        return verbosity;
    }

    private ArgumentsException unexpectedArgument(String arg) {
        return new ArgumentsException(String.format("Unexpected argument '%s'", arg));
    }

    private void parseLoadArguments(String[] args) throws ArgumentsException {
        mode = Mode.LOAD;

        var expectProject = false;
        var expectTarget = false;

        for (var i = 1; i < args.length; i++) {
            if (expectProject) {
                project = args[i];
                expectProject = false;
            } else if (expectTarget) {
                file = args[i];
                expectTarget = false;
            } else {
                switch (args[i]) {
                    case "-p" -> expectProject = true;
                    case "-t" -> expectTarget = true;
                    default -> parseArgument(args[i]);
                }
            }
        }

        if (expectProject || expectTarget) {
            throw new ArgumentsException("Missing argument");
        }
        if (project == null) {
            throw new ArgumentsException("Project is mandatory");
        }
        if (file == null) {
            throw new ArgumentsException("Target is mandatory");
        }
    }

    private void parseSaveArguments(String[] args) throws ArgumentsException {
        mode = Mode.SAVE;

        var expectProject = false;
        var expectSource = false;

        for (var i = 1; i < args.length; i++) {
            if (expectProject) {
                project = args[i];
                expectProject = false;
            } else if (expectSource) {
                file = args[i];
                expectSource = false;
            } else {
                switch (args[i]) {
                    case "-p" -> expectProject = true;
                    case "-s" -> expectSource = true;
                    default -> parseArgument(args[i]);
                }
            }
        }

        if (expectProject || expectSource) {
            throw new ArgumentsException("Missing argument");
        }
        if (project == null) {
            throw new ArgumentsException("Project is mandatory");
        }
        if (file == null) {
            throw new ArgumentsException("Source is mandatory");
        }
    }

    private void parseArgument(String arg) throws ArgumentsException {
        switch (arg) {
            case "-v" -> verbosity = Verbosity.INFO;
            case "-vv" -> verbosity = Verbosity.DEBUG;
            default -> throw unexpectedArgument(arg);
        }
    }
}
