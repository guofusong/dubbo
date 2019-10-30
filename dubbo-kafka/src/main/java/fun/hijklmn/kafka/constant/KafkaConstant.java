package fun.hijklmn.kafka.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KafkaConstant {

    public static String DEFAULT_BOOTSTRAP_SERVERS = "127.0.0.1:9092";

    public static String DEFAULT_GROUP_ID = "hijklmn";

    public static String ENABLE_AUTO_COMMIT = "TRUE";

    public static String AUTO_COMMIT_INTERVAL_MS = "1000";

    public static String AUTO_OFFSET_RESET = "earliest";

    public static String SESSION_TIMEOUT_MS = "30000";

    public static List<String> SUBSCRIBELIST = new ArrayList<String>(Arrays.asList("hijklmn"));

    public static String ACKS = "all";

    public static Integer RETRIES = 0;

    public static Integer BATCH_SIZE = 16384;

    public static Integer LINGER_MS = 1;

    public static Integer BUFFER_MEMORY = 33554432;

}
