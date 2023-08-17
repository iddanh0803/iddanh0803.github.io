package vn.techmaster.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import vn.techmaster.demo.model.BMI;

@CrossOrigin
@RestController
@RequestMapping("/bmi")
public class BMIController {
    @GetMapping("")
    public String getBMI(@RequestParam double height, @RequestParam double weight){
        return caculateBMI(height,weight);
    }

    @PostMapping("")
    public String postBMI(@RequestBody BMI request){
        double height = request.getHeight();
        double weight = request.getWeight();

        return caculateBMI(height,weight);
    }
    private String caculateBMI(double height, double weight) {
        if (height <=0 || weight <=0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Chiều cao và cân nặng phải lớn hơn 0");
        }
        double bmi = weight / (height * weight);
        String result = "";
        if (bmi < 18.5){
             result = "Thiếu cân";
        } else if (bmi >= 18.5 && bmi < 24.9) {
             result = "Bình thường";
        } else if (bmi > 25 && bmi < 29.9){
             result = "Thừa cân";
        } else{
             result = "Béo phí";
        }
        return "Chỉ số BMI: " + bmi + ", Kết quả: " + result;
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handlerInvalidType(ResponseStatusException e){
        return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
    }
}
