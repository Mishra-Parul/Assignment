package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //Call the getAllImages() method in the Repository and obtain a List of all the images in the database
    public List<Comment> getAllComments() {
        return commentRepository.getAll();
    }

    //The method calls the createImage() method in the Repository and passes the image to be persisted in the database
    public void post(Comment comment) {
        commentRepository.post(comment);
    }

}
