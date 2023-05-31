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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleepT_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String baby_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startT;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endT;
    private int turn_cnt;

    public void setUser(User user){
        this.user = user;
    }

    public static SleepTime createSleepTime(User user, String baby_name, LocalDateTime startT, LocalDateTime endT, int turn_cnt){
        SleepTime sleepTime = new SleepTime();
        sleepTime.setUser(user);
        sleepTime.setBaby_name(baby_name);
        sleepTime.setStartT(startT);
        sleepTime.setEndT(endT);
        sleepTime.setTurn_cnt(turn_cnt);
        return sleepTime;
    }
}
