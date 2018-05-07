package org.thepoet;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 6.05.2018
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "org.thepoet.elasticsearch.dao")
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String elasticsearchHost;
    @Value("${elasticsearch.port}")
    private int elasticsearchPort;
    @Value("${elasticsearch.clustername}")
    private String elasticsearchClusterName;

    @Bean
    public Client client() throws Exception {
        try {
            Settings elasctisearchSettings = Settings.builder().put("cluster.name", elasticsearchClusterName).build();
            InetSocketTransportAddress inetSocketTransportAddress = new InetSocketTransportAddress(InetAddress.getByName(elasticsearchHost), elasticsearchPort);
            TransportClient transportClient = new PreBuiltTransportClient(elasctisearchSettings);
            transportClient.addTransportAddress(inetSocketTransportAddress);
            return transportClient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}