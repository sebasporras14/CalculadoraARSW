package edu.escuelaing.arsw.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class CalcController {

	@Autowired
	CurrentValue cv;
	@Autowired
	CurrentOperator op;

	@GetMapping("/sub")
	public String sub(
		@RequestParam(name="number", required=false, defaultValue="0")String valor,
		@RequestParam(name = "operator", required = false, defaultValue = "-") String operacion,
		Model model){
		if(!valor.isEmpty()){
			cv.setCurrentValue(cv.getCurrentValue() - Double.parseDouble(valor));
		}
		model.addAttribute("currval", cv.getCurrentValue());
		return "calculadora1";
	}
	@GetMapping("/add")
	public String add(@RequestParam(name="number", required=false, defaultValue="0")String valor, 
	@RequestParam(name = "operator", required = false, defaultValue = "+") String operacion,
	Model model){
		if(!valor.isEmpty()){
			cv.setCurrentValue(cv.getCurrentValue() + Double.parseDouble(valor));
		}
		model.addAttribute("currval", cv.getCurrentValue());
		return "calculadora1";
	}
	@GetMapping("/div")
	public String div(
		@RequestParam(name="number", required=false, defaultValue="1")String valor,
		@RequestParam(name = "operator", required = false, defaultValue = "/") String operacion, 
		Model model){
		if(!valor.isEmpty()){
			cv.setCurrentValue(cv.getCurrentValue() / Double.parseDouble(valor));
		}
		model.addAttribute("currval", cv.getCurrentValue());
		return "calculadora1";
	}
	@GetMapping("/mult")
	public String mult(@RequestParam(name="number", required=false, defaultValue="1")String valor, 
	@RequestParam(name = "operator", required = false, defaultValue = "*") String operacion,
	Model model){
		if(!valor.isEmpty()){
			cv.setCurrentValue(cv.getCurrentValue() * Double.parseDouble(valor));
		}
		model.addAttribute("currval", cv.getCurrentValue());
		return "calculadora1";
	}

	@GetMapping("/clean1")
	public String clean1(@RequestParam(name = "number", required = false, defaultValue = "0") String valor,
			Model model) {
		cv.setCurrentValue(0);
		model.addAttribute("currval", cv.getCurrentValue());
		return "calculadora1";
	}
	@GetMapping("/clean")
	public String clean(@RequestParam(name = "number", required = false, defaultValue = "0") String valor,
			Model model) {
		cv.setCurrentValue(0);
		model.addAttribute("currval", cv.getCurrentValue());
		return "calculadora";
	}
	@GetMapping("/operador")
	public String operador(@RequestParam(name="operator", required=false, defaultValue="+")String operacion, 
	Model model){
		op.setCurrentValue(operacion);
		model.addAttribute("op", op.getCurrentValue());
		return "calculadora";
	}
	/* 
	@GetMapping("/calc")
	public String defaulCalc() {
		if (op.getCurrentValue().equals("+")) {
			add(valor, operacion, model);
		} else if (op.getCurrentValue().equals("-")) {
			sub(valor, operacion, model);
		} else if (op.getCurrentValue().equals("*")) {
			mult(valor, operacion, model);
		} else if (op.getCurrentValue().equals("/")) {
			div(valor, operacion, model);
		}
		return "calculadora";
	}*/
	@GetMapping("/calc1")
	public String defaulCalc1(){
		return "calculadora1";
	}

}
