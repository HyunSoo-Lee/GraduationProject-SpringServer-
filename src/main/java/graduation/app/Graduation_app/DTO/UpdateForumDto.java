package graduation.app.Graduation_app.DTO;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateForumDto {
    private String title;
    private String contents;
    private LocalDateTime postT;
}
