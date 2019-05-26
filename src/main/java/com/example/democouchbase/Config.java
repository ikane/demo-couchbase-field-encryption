package com.example.democouchbase;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.support.IndexManager;

import java.util.Collections;
import java.util.List;

@Configuration
public class Config extends AbstractCouchbaseConfiguration {
    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList("127.0.0.1");
    }

    @Override
    protected String getBucketName() {
        return "test";
    }

    @Override
    protected String getBucketPassword() {
        return "password";
    }

    @Override
    public CustomConversions customConversions() {
        return super.customConversions();
    }

    @Override
    public IndexManager indexManager() {
        return new IndexManager(true, true, true);
    }


}
