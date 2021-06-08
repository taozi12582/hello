package taozi;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReadConfiguration {
    public void readProperties() throws IOException {
        Properties props = new Properties();
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("yapi_setting.config")) {
            props.load(in);
            String filepath = props.getProperty("last_open_file");
            String interval = props.getProperty("auto_save_interval");
            System.out.println(filepath + "\n" + interval);
        }catch (NullPointerException e){
            System.out.println("文件未找到！从gui配置中读取");
        }

    }

    public static void readProperties2(){
        ResourceBundle bundle = ResourceBundle.getBundle("setting");
        String last_open_file = bundle.getString("last_open_file");
        System.out.println(last_open_file);
    }

    public static void readProperties3() throws IOException {
        String basePath = "D:/ExampleCode/hiworld/yapi_setting.config";
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
         BufferedReader bufferedReader = new BufferedReader(new FileReader(basePath));
         properties.load(bufferedReader);
        System.out.println(properties.getProperty("last_open_file"));
    }

    public static void main(String[] args) throws IOException {
        new ReadConfiguration().readProperties3();
    }
}
