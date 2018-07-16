package org.thepoet.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.thepoet.elasticsearch.model.Log;

import java.util.Date;
import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 10.05.2018
 */
public interface LogDao extends ElasticsearchRepository<Log, String> {
    List<Log> findByType(String type);

    List<Log> findByMerchantId(String merchantId);

    List<Log> findAllByCreatedDateBefore(Date createdDate);
}
