package graduation.app.Graduation_app.DTO;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateSleepTimeDto {
    private LocalDateTime startT;
    private LocalDateTime endT;
    private int turn_cnt;
}
