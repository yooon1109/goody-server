package org.re.goody.sample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.re.goody.sample.service.SampleService;
import org.re.sample.domain.Sample;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "샘플 API", description = "샘플 테스트용 API")
@RestController
@RequestMapping("/samples")
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;

    @Operation(summary = "헬로 월드 반환", description = "간단한 테스트용 헬로 월드 메시지를 반환합니다.")
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, Goody Server!";
    }

    @Operation(summary = "메시지 생성", description = "")
    @PostMapping
    public ResponseEntity<Sample> createSample(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        Sample savedSample = sampleService.saveSample(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSample);
    }

    @Operation(summary = "메시지 수정", description = "")
    @PutMapping("/{id}")
    public ResponseEntity<Sample> updateSample(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String newMessage = request.get("message");
        Sample updatedSample = sampleService.updateMessage(id, newMessage);
        return ResponseEntity.ok(updatedSample);
    }

    @Operation(summary = "아이디로 메시지 반환", description = "간단한 테스트용 헬로 월드 메시지를 반환합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<Sample> getSample(@PathVariable Long id) {
        return sampleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
