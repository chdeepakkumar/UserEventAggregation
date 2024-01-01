package assessment.sugarbox.util;

import assessment.sugarbox.model.AggregatedEvents;
import assessment.sugarbox.model.Event;
import assessment.sugarbox.model.EventType;
import assessment.sugarbox.model.Pair;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EventsProcessor {

    private static ObjectMapper mapper = new ObjectMapper();
    private static Logger log = Logger.getLogger(EventsProcessor.class.getName());

    public static void processEvents(File inputFile, File outputFile,
                                     Boolean isRealTime, Integer sleep) throws IOException {
        FileReader fileReader = null;
        BufferedReader reader = null;
        FileWriter fileWriter;
        BufferedWriter writer;
        Map<Pair, AggregatedEvents> data = new HashMap<>();
        try {
            fileReader = new FileReader(inputFile);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while(true) {
                if(line != null) {
                    fileWriter = new FileWriter(outputFile);
                    writer = new BufferedWriter(fileWriter);
                    Event event = mapper.readValue(line, Event.class);
                    String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(event.getTimestamp()*1000));
                    Pair pair = new Pair(event.getUserId(), date);
                    if(!data.containsKey(pair))
                        data.put(pair, new AggregatedEvents(event.getUserId(), date, new HashMap<>()));
                    data.put(pair, getAggregatedEvents(event, data.get(pair)));
                    writer.flush();
                    writer.write(mapper.writeValueAsString(data.values()));
                    writer.close();
                    fileWriter.close();
                }
                else {
                    if(!isRealTime)
                        break;
                    else  {
                        Thread.sleep(sleep*1000);
                        log.info("Looking for new events: " + System.currentTimeMillis());
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reader.close();
            fileReader.close();
        }
    }

    private static AggregatedEvents getAggregatedEvents(Event event, AggregatedEvents aggregatedEvents) {
        Map<EventType, Integer> eventCount = aggregatedEvents.getEvents();
        eventCount.put(event.getEventType(), eventCount.getOrDefault(event.getEventType(), 0) + 1);
        return aggregatedEvents;
    }
}
