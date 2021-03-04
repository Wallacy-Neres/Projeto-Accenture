package accenture.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import accenture.DTO.ExtratoDTO;
import accenture.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping
	public ExtratoDTO getDashboard(@RequestParam("login") String login, @RequestParam("dataInicio") String dataInicio, @RequestParam("dataFim") String dataFim) throws ParseException{
		return dashboardService.getExtrato(login, dataInicio, dataFim);
	}
	
}