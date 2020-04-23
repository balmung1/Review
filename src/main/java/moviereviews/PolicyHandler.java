package moviereviews;

import moviereviews.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired
    ReviewRepository reviewRepos;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMovieCreated_MovieInfoCreated(@Payload MovieCreated movieCreated){

        if(movieCreated.isMe()){
            System.out.println("##### listener MovieCreated : " + movieCreated.toJson());

            Review review = new Review();
            review.setTitle(movieCreated.getTitle());
            review.setOpenStatus(movieCreated.getOpenStatus());
            reviewRepos.save(review);
        }

    }

}
