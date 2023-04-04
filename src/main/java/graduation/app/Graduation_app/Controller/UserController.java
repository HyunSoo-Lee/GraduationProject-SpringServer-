package graduation.app.Graduation_app.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graduation.app.Graduation_app.DTO.*;
import graduation.app.Graduation_app.Domain.Forum;
import graduation.app.Graduation_app.Domain.SleepTime;
import graduation.app.Graduation_app.Domain.User;
import graduation.app.Graduation_app.Service.UserService;
import graduation.app.Graduation_app.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //회원 가입
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody AddUserDto addUserDto){
        userService.createUser(addUserDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }

    //회원정보 수정
    @PostMapping("/edit/userId/{userId}")
    public ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto userDto) {

        Long user = userService.updateUser(userId, userDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, user));
    }

    //내가 생성한 게시글 보여주기
    @GetMapping("/get/forum/userId/{userId}")
    public ResponseEntity getMyForumList(@PathVariable Long userId){

        List<Forum> forum = userService.getMyforumList(userId);

        List<MyForumDto> collect = forum.stream().map(r -> new MyForumDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }
    
    //내가 생성한 수면시간 테이블 보여주기
    @GetMapping("/get/sleeptime/userId/{userId}")
    public ResponseEntity getMySleepTimeList(@PathVariable Long userId){

        List<SleepTime> sleepTime = userService.getMysleepList(userId);

        List<MySleepTimeDto> collect = sleepTime.stream().map(r -> new MySleepTimeDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    @GetMapping("/get/userId/{nickname}&{password}")
    public ResponseEntity getUserId(@PathVariable String nickname, @PathVariable String password) {
        Long userId = userService.getMyUserIdList(nickname, password);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode userIdJson = mapper.convertValue(userId, JsonNode.class);
        return ResponseEntity.ok().body(userIdJson);
    }

    //회원 탈퇴
    @DeleteMapping("/delete/userId/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }

}
