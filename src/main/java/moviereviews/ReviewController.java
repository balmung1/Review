package moviereviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class ReviewController {
  @Autowired
  ReviewRepository reviewRepository;

  @RequestMapping(method = RequestMethod.PATCH, path = "/movies")
  public void reservation(@RequestBody Review review1) {
   Review review = new Review();

   review.setId(review1.getId());
   review.setTitle(review1.getReviewTitle());
   review.setReviewContents(review1.getReviewContents());
   reviewRepository.save(review);
  }

 }
