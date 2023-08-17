package vn.techmaster.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;
@CrossOrigin

@RestController
public class RandomColorController {
    @GetMapping("/randomcolor")
    public String getRamdomColor(@RequestParam("type") int typeValue) {
        switch (typeValue) {
            case 1:
                return getRamdomColorName();
            case 2:
                return getRamdomHexColor();
            case 3:
                return getRamdomRgbColor();
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type không hợp lệ");
        }
    }
    private String getRamdomColorName() {
        String[] colorNames = {"black", "blue", "red", "green"};
        int ramdomIndex = new Random().nextInt(colorNames.length);
        return colorNames[ramdomIndex];
    }
    private String getRamdomHexColor() {
        Random rd = new Random();
        return String.format("#%02X%02X%02X", rd.nextInt(256), rd.nextInt(256), rd.nextInt(256));
    }
    @GetMapping("")
    private String getRamdomRgbColor() {
        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return String.format("rgb(%d, %d, %d)", r, g, b);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleInvalidType(ResponseStatusException e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
    }
}
