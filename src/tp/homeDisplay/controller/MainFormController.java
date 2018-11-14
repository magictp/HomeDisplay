package tp.homeDisplay.controller;

import tp.homeDisplay.service.MetroService;

public class MainFormController {

	public String getOncomingMetro(){
		return new MetroService().getOncomingShift();
	}
}
