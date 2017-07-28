package com.springboottest.util;

import com.springboottest.domain.ResponseMessage;
import org.apache.log4j.Logger;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/13.
 * 定时任务类
 */
@Component
public class ScheduledTasks {
    private static Logger log = Logger.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000000)
    private void reportCurrentTime() {
        log.debug("现在时间：" + dateFormat.format(new Date()));
    }
}
