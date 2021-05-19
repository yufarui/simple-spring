package yu.controller;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class RunShellUtil {

    public static String runScript(String... cmd) {
        StringBuffer buf = new StringBuffer();
        String rt;
        String ln;
        try {
            Process pos = Runtime.getRuntime().exec(cmd);
            pos.waitFor();
            try (LineNumberReader input = new LineNumberReader(new InputStreamReader(pos.getInputStream()))) {
                while ((ln = input.readLine()) != null) {
                    buf.append(ln + "\n");
                }
                rt = buf.toString();
            }
        } catch (Exception e) {
            throw new RuntimeException("execute command fail", e);
        }
        return rt;
    }

}