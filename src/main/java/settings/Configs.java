package settings;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import utils.logger.TestLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Properties;

public class Configs {

    private static final Logger logger = TestLogger.logger;
    private static final String envJSONFilePath = "src/main/java/settings/env.json";
    private static Configs webConfigs;
    private String browser;
    private boolean localRun;
    private String url;


    public static Configs getWebConfigs() {
        if (webConfigs == null) {
            webConfigs = new Configs();
        }
        return webConfigs;
    }

    Configs() {
        Properties property = getConfigsReader();
        this.browser = property.getProperty("browser");
        this.url = (String) parseSettingsJSON(envJSONFilePath).get("qa_env");
        System.out.println(url);
    }

    private String getFilePropertyPath() {
        String basePath = "src/main/resources";
        String localConfigFile = basePath + "/env_local.properties";
        String defaultConfigFile = basePath + "/env.properties";
        File localFile = new File(localConfigFile);

        this.localRun = localFile.exists();

        return localFile.exists() ? localConfigFile : defaultConfigFile;
    }

    private Properties getConfigsReader() {
        Properties property = new Properties();
        String filePath = getFilePropertyPath();
        try (FileInputStream propertyFile = new FileInputStream(filePath)){
            property.load(propertyFile);
        } catch (IOException e) {
            logger.error("Cannot read properties file");
        }

        return property;
    }

    public JSONObject parseSettingsJSON(String file) {
        try (InputStream is = new FileInputStream(file)){
            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
            return new JSONObject(jsonTxt);
        } catch (IOException e) {
            logger.error("Cannot read setting JSON file");
        }
        return null;
    }

    public String getBrowser() {
        return this.browser;
    }

    public boolean isChrome() {
        return this.browser.equals("chrome");
    }

    public String getUrl() {
        return url;
    }
}
