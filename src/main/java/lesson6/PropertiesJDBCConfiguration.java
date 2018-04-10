package lesson6;

import java.io.*;
import java.util.Properties;

public class PropertiesJDBCConfiguration implements JDBCConfiguration {

    private static String NAME;
    private static String HOST;
    private static int PORT;
    private static String USERNAME;
    private static String PASSWORD;

    @Override
    public Configuration load() {

        Configuration conf = new Configuration();

                Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src\\main\\resources\\database.properties")));
            NAME = properties.getProperty("jdbc.database.name");
            HOST = properties.getProperty("jdbc.host");
            PORT = Integer.parseInt(properties.getProperty("jdbc.port"));
            USERNAME = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");

            conf.setDatabase(NAME);
            conf.setHost(HOST);
            conf.setPort(PORT);
            conf.setUsername(USERNAME);
            conf.setPassword(PASSWORD);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return conf;
    }
}