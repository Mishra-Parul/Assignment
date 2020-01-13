package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import ImageHoster.service.CommentService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createImage(@PathVariable("imageId") Integer imageId,
                              @PathVariable("imageTitle") String title,
                              @RequestParam("comment") String comments,
                              HttpSession session) throws IOException {

        User user=(User) session.getAttribute("user");
        Image image=imageService.getImage(imageId);
        Comment comment=new Comment();
        comment.setText(comments);
        comment.setImage(image);
        comment.setUser(user);
        commentService.post(comment);

        return "redirect:/images/" + imageId;
    }


    }
