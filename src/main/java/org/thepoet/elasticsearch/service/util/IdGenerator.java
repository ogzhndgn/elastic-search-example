package org.thepoet.elasticsearch.service.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.05.2018
 */
@Component
public class IdGenerator {

    public String generateId() {
        UUID uuid = UUID.randomUUID();
        String uniqueId = uuid.toString();
        return StringUtils.removeAll(uniqueId, "-");
    }
}
