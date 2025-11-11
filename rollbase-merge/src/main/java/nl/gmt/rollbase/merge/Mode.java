package nl.gmt.rollbase.merge;

/**
 * Represents the operation mode of the Rollbase merge tool.
 * <p>
 * The tool supports two primary operations:
 * <ul>
 *   <li>LOAD - Loads a Rollbase project and creates an XML export</li>
 *   <li>SAVE - Saves an XML export into the version control repository</li>
 * </ul>
 */
public enum Mode {
    /**
     * Load mode: creates an XML Application export from a Rollbase project.
     */
    LOAD,
    
    /**
     * Save mode: saves an XML Application export into the version control repository.
     */
    SAVE
}
