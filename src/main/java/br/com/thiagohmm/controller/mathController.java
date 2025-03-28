package br.com.thiagohmm.controller;

import br.com.thiagohmm.exception.InvalidNumberException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/math")
public class mathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Map<String, Double> sum (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        try {
            Double result = Double.parseDouble(numberOne.replace(",", ".")) + Double.parseDouble(numberTwo.replace(",", "."));
            Map<String, Double> response = new HashMap<>();
            response.put("result", result);
            return response;
        }catch (NumberFormatException ex){
            throw new InvalidNumberException("Invalid number format" + ex.getMessage());
        }
    }



    @GetMapping("/division/{numberOne}/{numberTwo}")
    public  Map<String, Double> division (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        try {
            Double result = Double.parseDouble(numberOne.replace(",", ".")) / Double.parseDouble(numberTwo.replace(",", "."));
            if (result.isNaN()) {
                throw new InvalidNumberException("Result is NaN (Not a Number). Invalid operation.");
            }
            if (result.isInfinite()){
                throw new InvalidNumberException("Result is Infinite. Invalid operation.");
            }
            Map<String, Double> response = new HashMap<>();
            response.put("result", result);
            return response;
        }catch (NumberFormatException ex){
            throw new InvalidNumberException("Invalid number format" + ex.getMessage());
        }catch (ArithmeticException ex){
            throw new InvalidNumberException("Division by zero is not allowed");
        }
    }

}
