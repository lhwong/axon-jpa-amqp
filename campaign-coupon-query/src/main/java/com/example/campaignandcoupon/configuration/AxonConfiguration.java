package com.example.campaignandcoupon.configuration;




import org.axonframework.extensions.amqp.eventhandling.AMQPMessageConverter;
import org.axonframework.extensions.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.client.Channel;




@Configuration
public class AxonConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(AxonConfiguration.class);

  
    /*@Bean
    public SpringAMQPMessageSource complaintEventsMethod(Serializer serializer) {
        return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)) {

            @RabbitListener(queues = "${axon.amqp.exchange}")
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                LOG.debug("Event Received: {}", message.getBody().toString());
                super.onMessage(message, channel);
            }
        };
    }*/
    
    @Bean
    public SpringAMQPMessageSource complaintEventsMethod(AMQPMessageConverter messageConverter) {
        return new SpringAMQPMessageSource(messageConverter) {

            @RabbitListener(queues = "${axon.amqp.exchange}")
            @Override
            public void onMessage(Message message, Channel channel) {
                super.onMessage(message, channel);
            }
        };
    }
    
  /* @Bean
    XStream xstream(){
        XStream xstream = new XStream();
        // clear out existing permissions and set own ones
        xstream.addPermission(NoTypePermission.NONE);
        // allow any type from the same package
        xstream.allowTypesByWildcard(new String[] {
                "com.seveneleven.**",
                "com.razerpay.seveneleven.**",
                "org.axonframework.**",
                "java.**",
                "com.thoughtworks.xstream.**"
        });

        return xstream;
    }
    
    @Primary
    @Bean
    public Serializer serializer(XStream xStream) {
        return XStreamSerializer.builder().xStream(xStream).build();
    }*/
}
