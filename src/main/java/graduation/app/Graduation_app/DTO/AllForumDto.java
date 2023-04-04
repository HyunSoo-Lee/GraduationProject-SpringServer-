package graduation.app.Graduation_app.DTO;

import graduation.app.Graduation_app.Domain.Forum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllForumDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime postT;
    public AllForumDto(Forum forum){
        id = forum.getId();
        title = forum.getTitle();
        contents = forum.getContents();
        postT = forum.getPostT();
    }
}
