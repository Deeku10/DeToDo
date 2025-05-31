package in.builtbydeeku.detodo_springboot.Controllers;

import in.builtbydeeku.detodo_springboot.Models.Period;
import in.builtbydeeku.detodo_springboot.Response.ApiResponse;
import in.builtbydeeku.detodo_springboot.Services.PeriodService.PeriodService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/period")
public class PeriodController {

//    public List<Period> getAllPeriods();
//
    @Autowired
    private PeriodService periodService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPeriod(@RequestBody Period period) {
        try {
            return ResponseEntity.ok(new ApiResponse(periodService.addPeriod(period), "Add period successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Add period failure"));
        }
    }

    @PostMapping("/update/{periodId}")
    public ResponseEntity<ApiResponse> updatePeriod(@RequestBody Period period, @PathVariable int periodId) {
        try {
            return ResponseEntity.ok(new ApiResponse(periodService.updatePeriodById(period, periodId), "Period updated."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Period update failure"));
        }
    }

    @DeleteMapping("/delete/{periodId}")
    public ResponseEntity<ApiResponse> deletePeriod(@PathVariable int periodId) {
        try{
            periodService.deletePeriodById(periodId);
            return ResponseEntity.ok(new ApiResponse(periodId,"Period Deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Unable to delete periodz"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPeriods() {
        try{
            return ResponseEntity.ok(new ApiResponse(periodService.getAllPeriods(), "Success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Failure"));
        }
    }
}
