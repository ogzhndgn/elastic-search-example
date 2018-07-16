package org.thepoet.elasticsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thepoet.elasticsearch.dao.LogDao;
import org.thepoet.elasticsearch.model.Log;
import org.thepoet.elasticsearch.service.util.IdGenerator;

import java.util.Date;
import java.util.Random;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 10.05.2018
 */
@Service
public class LogServiceImpl implements LogService {
    private String[] typeArray = new String[]{"API EXCEPTION", "PAYMENT_GATEWAY_EXCEPTION", "INPUT_VALIDATION_EXCEPTION"};
    private String[] levelArray = new String[]{"INFO", "DEBUG", "WARNING", "ERROR", "FATAL"};
    private String[] merchantIdArray = new String[]{"POS", "DT", "PT", "PAT", "RS", "AB"};

    @Autowired
    private LogDao logDao;
    @Autowired
    private LogDetailService logDetailService;
    @Autowired
    private IdGenerator idGenerator;

    @Override
    public Log createLog() {
        Log log = new Log();
        log.setId(idGenerator.generateId());
        log.setType(this.getSampleType());
        log.setLevel(this.getSampleLevel());
        log.setCreatedDate(new Date());
        log.setDetail(logDetailService.generateLogDetail());
        log.setMerchantId(this.getSampleMerchantId());
        logDao.save(log);
        return log;
    }

    private String getSampleType() {
        Random random = new Random();
        int typeIndex = random.nextInt(3);
        return typeArray[typeIndex];
    }

    private String getSampleLevel() {
        Random random = new Random();
        int levelIndex = random.nextInt(5);
        return levelArray[levelIndex];
    }

    private String getSampleMerchantId() {
        Random random = new Random();
        int merchantIdIndex = random.nextInt(6);
        return merchantIdArray[merchantIdIndex];
    }
}
