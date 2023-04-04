package graduation.app.Graduation_app.DTO;

import graduation.app.Graduation_app.Domain.SleepTime;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MySleepTimeDto {
    private Long id;
    private LocalDateTime startT;
    private LocalDateTime endT;
    private int turn_cnt;

    public MySleepTimeDto(SleepTime sleepTime){
        id = sleepTime.getId();
        startT = sleepTime.getStartT();
        endT = sleepTime.getEndT();
        turn_cnt = sleepTime.getTurn_cnt();
    }

}
