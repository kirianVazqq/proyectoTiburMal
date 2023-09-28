package com.kirian.reminders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kirian.reminders.entity.models.Reminder;
import com.kirian.reminders.entity.services.IReminderService;

@RestController
@CrossOrigin(origins = "*")

public class ReminderController {
	@Autowired
	IReminderService reminderService;

	@GetMapping("/reminders")
	public List<Reminder> getAllReminders() {
		return reminderService.getAll();
	}

	@GetMapping("/reminders/{id}")
	public Reminder getOne(@PathVariable(value = "id") long id) {
		return reminderService.get(id);
	}

	@PutMapping("/reminders/{id}")
	public void put(@RequestBody Reminder reminder, @PathVariable(value = "id") long id) {
		reminderService.put(reminder, id);
	}

	@DeleteMapping("/reminders/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		reminderService.delete(id);
	}
	@PostMapping("/reminders")
	public void post(@RequestBody Reminder reminder) {
		reminderService.post(reminder);
	}


		
	


}
