package com.example.democouchbase.secure;

import com.example.democouchbase.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.couchbase.core.mapping.CouchbaseDocument;
import org.springframework.data.couchbase.core.mapping.event.AbstractCouchbaseEventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class AbstractEncryptionEventListener<T> extends AbstractCouchbaseEventListener {


    @Override
    public void onBeforeSave(Object source, CouchbaseDocument doc) {
        //super.onBeforeSave(source, doc);
        //Person person = (Person) source;

        //Set<Map.Entry<String, Object>> entrySet = doc.getPayload().entrySet();
        Set<String> fields = doc.getPayload().keySet();
        for(String fieldName: fields) {
            if (fieldName.equals("_class")) continue;
            Field classField = ReflectionUtils.findField(Person.class, fieldName);
            if (classField == null) continue;

            Object fieldValue = doc.get(fieldName);

            if (classField.isAnnotationPresent(Encrypted.class)) {
                // direct encryption
                doc.put(fieldName, ((String)fieldValue) + "-encrypted");
            }

        }
    }
}
