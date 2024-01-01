package assessment.sugarbox;

import assessment.sugarbox.util.ArgsParser;
import assessment.sugarbox.util.EventsProcessor;

import java.io.File;


public class Driver {
    public static void main(String[] args) throws Exception {

        File inputFile = ArgsParser.fetchInputFile(args);
        File outputFile = ArgsParser.fetchOutputFile(args);
        Boolean isRealTime = ArgsParser.ifRealTime(args);
        Integer sleepTime = ArgsParser.getSleepInterval(args);
        EventsProcessor.processEvents(inputFile, outputFile, isRealTime, sleepTime);
    }
}
