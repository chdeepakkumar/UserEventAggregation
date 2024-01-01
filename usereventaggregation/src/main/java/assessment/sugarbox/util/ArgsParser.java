package assessment.sugarbox.util;

import java.io.File;

public class ArgsParser {

    public static File fetchInputFile(String[] args) throws Exception {
        int n = args.length;
        if(n == 0)
            throw new Exception("Missing Arguments");
        for(int i=0;i<n;i++) {
            if(args[i].equals(UtilConstants.INPUT_PARAM) && i+1 < n) {
                String path = args[i+1];
                File inputFile = new File(path);
                if(inputFile.exists() && inputFile.isFile())
                    return inputFile;
                else throw new Exception("Invalid input file path");
            }
        }
        throw new Exception("Missing input file path");
    }

    public static File fetchOutputFile(String[] args) throws Exception {
        int n = args.length;
        if(n == 0)
            throw new Exception("Missing Arguments");
        for(int i=0;i<n;i++) {
            if(args[i].equals(UtilConstants.OUTPUT_PARAM) && i+1 < n) {
                String path = args[i+1];
                File inputFile = new File(path);
                if(inputFile.exists() && inputFile.isFile())
                    return inputFile;
                else throw new Exception("Invalid output file path");
            }
        }
        throw new Exception("Missing output file path");
    }

    public static Boolean ifRealTime(String[] args) {
        for(String arg: args) {
            if(arg.equals(UtilConstants.UPDATE_PARAM))
                return true;
        }
        return false;
    }
    public static Integer getSleepInterval(String[] args) {
        int n = args.length;
        if(n == 0)
            return UtilConstants.DEFAULT_SLEEP_TIME;
        for(int i=0;i<n;i++) {
            if(args[i].equals(UtilConstants.SLEEP_PARAM) && i+1<n) {
                try {
                    return Integer.parseInt(args[i + 1]);
                } catch (Exception e) {
                    return UtilConstants.DEFAULT_SLEEP_TIME;
                }
            }
        }
        return UtilConstants.DEFAULT_SLEEP_TIME;
    }
}
