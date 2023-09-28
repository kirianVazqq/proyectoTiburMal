package com.kirian.reminders.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.kirian.reminders.entity.models.Reminder;

public interface IReminderDao extends CrudRepository<Reminder,Long>{

}
