package photorganisation.batch.configuration;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {
    private static volatile PropertyConfig instance = null;

    private final Properties properties;
    private final String directoryToProcess;
    private final String rootDirectory;

    private PropertyConfig(String resourceFileName) {
        this.properties = getProperties(resourceFileName);
        this.rootDirectory = this.properties.getProperty("rootDirectory");
        this.directoryToProcess = this.properties.getProperty("directoryToProcess");
    }

    public static PropertyConfig getInstance(String resourceFileName) {
        if(instance == null) {
            synchronized (PropertyConfig.class) {
                if(instance == null) {
                    instance = new PropertyConfig(resourceFileName);
                }
            }
        }

        return instance;
    }

    private Properties getProperties(String resourceFileName) {
        Properties configuration = new Properties();

        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(resourceFileName)) {
            if(inputStream != null) {
                configuration.load(inputStream);
            }
            else {
                throw new FileNotFoundException("property file '" + resourceFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception au moment du chargement : " + e);
        }

        return configuration;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getDirectoryToProcess() {
        return directoryToProcess;
    }

    public String getRootDirectory() {
        return rootDirectory;
    }
}
