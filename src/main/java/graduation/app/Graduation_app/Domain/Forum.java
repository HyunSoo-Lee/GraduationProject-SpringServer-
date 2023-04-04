package graduation.app.Graduation_app.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Forum {
    @Id
    @GeneratedValue
    @Column(name = "forum_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_nickname")
    private String user_nickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime postT;

    private String title;
    private String contents;

    public void setUser(User user){
        this.user = user;
    }

    public static Forum createForum(User user, LocalDateTime postT, String title, String contents, String user_nickname){
        Forum forum = new Forum();
        forum.setUser(user);
        forum.setPostT(postT);
        forum.setTitle(title);
        forum.setContents(contents);
        forum.setUser_nickname(user_nickname);
        return forum;
    }
}
