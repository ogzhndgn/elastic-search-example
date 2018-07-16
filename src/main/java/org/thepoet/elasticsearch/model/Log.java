package org.thepoet.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 10.05.2018
 */
@Document(indexName = "gogogo", type = "logs")
public class Log {
    @Id
    private String id;
    private String type;
    private String level;
    private Date createdDate;
    private String detail;
    private String merchantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", createdDate=" + createdDate +
                ", detail='" + detail + '\'' +
                ", merchantId='" + merchantId + '\'' +
                '}';
    }
}
