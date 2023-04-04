package graduation.app.Graduation_app.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SuccessResponse {

    private final boolean success = true;
    private final int status;
    private final Object data;
    private final LocalDateTime timeStamp;

    @Builder
    public SuccessResponse(int status, Object data) {
        this.status = status;
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }
}