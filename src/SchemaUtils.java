import java.io.*;

public class SchemaUtils {


    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            return new String(filecontent, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("==============================");
            System.out.println("请输入schema.json路径");
            System.out.println("==============================");
            return;
        }
        String path = args[0];
        System.out.println("==============================");
        System.out.println("schema.json路径 : " + path);
        System.out.println("==============================");
        File file = new File(path);
        String s = readToString(file.getPath());
        String newStr = s.replace("\"Query\"", "\"QueryRoot\"");
        PrintStream ps = new PrintStream(file);
        ps.print(newStr);
        ps.flush();
        ps.close();
        System.out.println("==============================");
        System.out.println("old : ");
        System.out.println("==============================");
        System.out.println(s);

        System.out.println("==============================");
        System.out.println("new : ");
        System.out.println("==============================");
        System.out.println(newStr);

        System.out.println("==============================");
        System.out.println("完成");
        System.out.println("==============================");
    }
}
