package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SeleniumConfigs {
    public  List<String> pagesPaths2Visit;
    public String DOWNLOAD_FOLDER;
    public String COOKIE_AUTH_TOKEN;
    public  String FILE_UPLOAD_TEST;
    public  String TARGET_WEBSITE;
    public int waitDuration;
    public  String HEADERS_AGENT;
    public  String TEMP_MAIL_WEBSITE;
    public  String goodUsername;
    public  String goodPassword;
    public  String changePasswordTemp;
    public  String wrongUsername;
    public  String wrongPassword;
    public  BusinessAddress businessAddress;

    public static class BusinessAddress {
        public String street;
        public String city;
        public String state;
        public String zip;
        public String country;

        @Override
        public String toString() {
            return street + '\n' + city + '\n' + state + '\n' + zip + '\n' + country;
        }
    }

    public static SeleniumConfigs loadConfigs() {
        final File configFile = new File(System.getProperty("user.dir") + "/src/test/java/config/configs.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(configFile, SeleniumConfigs.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String businessAdr() {
        return businessAddress.toString();
    }

    public String getFullTargerLink() {
        return "https://" + TARGET_WEBSITE;
    }

    @Override
    public String toString() {
        return "SeleniumConfigs{" +
                "pagesPaths2Visit=" + pagesPaths2Visit +
                ", DOWNLOAD_FOLDER='" + DOWNLOAD_FOLDER + '\'' +
                ", FILE_UPLOAD_TEST='" + FILE_UPLOAD_TEST + '\'' +
                ", TARGET_WEBSITE='" + TARGET_WEBSITE + '\'' +
                ", waitDuration=" + waitDuration +
                ", HEADERS_AGENT='" + HEADERS_AGENT + '\'' +
                ", TEMP_MAIL_WEBSITE='" + TEMP_MAIL_WEBSITE + '\'' +
                ", goodUsername='" + goodUsername + '\'' +
                ", goodPassword='" + goodPassword + '\'' +
                ", changePasswordTemp='" + changePasswordTemp + '\'' +
                ", wrongUsername='" + wrongUsername + '\'' +
                ", wrongPassword='" + wrongPassword + '\'' +
                ", businessAddress=" + businessAddress +
                '}';
    }
}
