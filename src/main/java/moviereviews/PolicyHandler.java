package moviereviews;

import moviereviews.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewWrited_MovieInfoUpdated(@Payload ReviewWrited reviewWrited){

        if(reviewWrited.isMe()){
            System.out.println("##### listener MovieInfoUpdated : " + reviewWrited.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMovieUpdated_MovieInfoUpdated(@Payload MovieUpdated movieUpdated){

        if(movieUpdated.isMe()){
            System.out.println("##### listener MovieInfoUpdated : " + movieUpdated.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMovieCreated_MovieInfoCreated(@Payload MovieCreated movieCreated){

        if(movieCreated.isMe()){
            System.out.println("##### listener MovieInfoCreated : " + movieCreated.toJson());
        }
    }

}
