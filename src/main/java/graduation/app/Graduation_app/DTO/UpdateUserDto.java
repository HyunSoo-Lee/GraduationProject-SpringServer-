package graduation.app.Graduation_app.DTO;

import graduation.app.Graduation_app.Domain.Gender;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class UpdateUserDto {
    private String baby_name;
    private String nickname;
    private String password;
    private Gender baby_gender;
    private LocalDateTime baby_birth;
}
