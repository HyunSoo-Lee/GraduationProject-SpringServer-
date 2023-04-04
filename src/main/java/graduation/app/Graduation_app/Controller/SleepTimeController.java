package graduation.app.Graduation_app.Controller;

import graduation.app.Graduation_app.DTO.CreateSleepTimeDto;
import graduation.app.Graduation_app.DTO.UpdateSleepTimeDto;
import graduation.app.Graduation_app.Domain.SleepTime;
import graduation.app.Graduation_app.Service.SleepTimeService;
import graduation.app.Graduation_app.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sleepTime")
@RequiredArgsConstructor
public class SleepTimeController {
    private final SleepTimeService sleepTimeService;

    //수면시간 생성하기
    @PostMapping("/create/userId/{userId}")
    public ResponseEntity createSleepTime(@PathVariable Long userId, @RequestBody CreateSleepTimeDto createSleepTimeDto){

        Long sleepTimeId = sleepTimeService.createSleepTime(userId,createSleepTimeDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,sleepTimeId));
    }

    //수면시간 업데이트
    @PostMapping("/edit/sleepTimeId/{sleepTimeId}")
    public ResponseEntity updateSleepTime(@PathVariable Long sleepTimeId, @RequestBody UpdateSleepTimeDto sleepTimeDto) {

        Long sleepTime = sleepTimeService.updateSleepTime(sleepTimeId, sleepTimeDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, sleepTime));
    }

    //수면시간 삭제하기
    @DeleteMapping("/delete/sleepTimeId/{sleepTimeId}")
    public ResponseEntity deleteSleepTime(@PathVariable Long sleepTimeId){

        sleepTimeService.deleteSleepTime(sleepTimeId);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, null));
    }

}
