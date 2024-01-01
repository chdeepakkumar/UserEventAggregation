***User Event Aggregation CLI***

This is a CLI application that aggregates user activity events to generate daily summary reports.

**How to run**

1. For reading the file once and generating output;\
1.1. Run the provided jar file using the command `java -jar event-aggregator.jar -i <input file path> -o <output file path>`\
1.2. This will read the input file and generate the output in the file provided in the arguments.
2. For realtime processing;\
2.1. Run the provided jar file using the command `java -jar event-aggregator.jar -i <input file path> -o <output file path> -s <sleep time in sec> --update`\
2.2. This will read the input file in real time and generate the output in the file provided in the arguments.\
2.3. Default and recommended sleep time is 5 seconds and it is used to check for new events periodically.

**Input File Format**

**Sample input file has been provided.
1. File should contain information about events.
2. Each line in the file represents one event.
3. The file should not contain square brackets([]) and commas(,) for JSON formatting or for separating events.
4. For every event;\
4.1. userId should be a valid integer value.\
4.2. timestamp sholud be a valid long value.\
4.3. eventType should be one of these 3 (1. post, 2. likeReceived, 3. comment).

**Output File**

The aggregated summery will be written to the output file passed in the arguments.