package graduation.app.Graduation_app.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class SleepTime {
    @Id
    @GeneratedValue
    @Column(name = "sleepT_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_babyName")
    private String user_baby;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startT;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endT;
    private int turn_cnt;

    public void setUser(User user){
        this.user = user;
    }

    public static SleepTime createSleepTime(User user, String user_baby, LocalDateTime startT, LocalDateTime endT, int turn_cnt){
        SleepTime sleepTime = new SleepTime();
        sleepTime.setUser(user);
        sleepTime.setUser_baby(user_baby);
        sleepTime.setStartT(startT);
        sleepTime.setEndT(endT);
        sleepTime.setTurn_cnt(turn_cnt);
        return sleepTime;
    }
}
