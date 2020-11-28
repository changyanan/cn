package com.example.demospringmvc.netty.protocol;

import org.jboss.marshalling.*;

import java.io.IOException;

/**
 * @author changyanan1
 */
public class MarshallingCodecFactory {
    /**
     * 创建Jboss Marshaller
     *
     * @return
     * @throws IOException
     */
    protected static Marshaller buildMarshaller() throws IOException {
        MarshallerFactory marshallerFactory = Marshalling.getMarshallerFactory("serial");
        MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        org.jboss.marshalling.Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
        return marshaller;
    }

    /**
     * 创建 Unmarshaller
     *
     * @return
     * @throws IOException
     */
    protected static Unmarshaller buildUnmarshaller() throws IOException {
        MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);
        return unmarshaller;
    }
}
