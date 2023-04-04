package graduation.app.Graduation_app.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String nickname;

    private String password;

    private String babyName;

    @Enumerated(EnumType.STRING)
    private Gender babyGender;

    private LocalDateTime babyBirth;

    // 생성 메서드
    public static User addUser(String babyName, String nickname, String password, Gender babyGender, LocalDateTime babyBirth) {
        User user = new User();
        user.setNickname(nickname);
        user.setPassword(password);
        user.setBabyName(babyName);
        user.setBabyGender(babyGender);
        user.setBabyBirth(babyBirth);
        return user;
    }
}