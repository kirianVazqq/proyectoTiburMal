import { Component } from '@angular/core';
import { ReminderService } from '../services/reminder.service';
import { PatternValidator } from '@angular/forms';
import { empty } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  editingId: number | null = null;
  cleanTextArea() {
    const textarea = document.getElementById('info') as HTMLTextAreaElement;
    if (textarea) {
      textarea.value = '';
    }
  }

  date = new Date();
  today = this.date.toLocaleDateString('fr-CA');

  reminders: any = [];
  constructor(private reminderService: ReminderService) {}

  ngOnInit() {
    this.getReminders();
  }
  getReminders() {
    this.reminderService.getReminders().subscribe((response) => {
      this.reminders = response;
    });
  }
  deleteReminder(id: number) {
    this.reminderService.deleteReminder(id).subscribe((response) => {
      this.reminders = response;
      this.getReminders();
    });
  }

  addReminder(date: string, info: string) {
    this.reminderService.addReminder(date, info).subscribe((response) => {
      this.reminders = response;
      this.getReminders();
      this.cleanTextArea();
    });
  }

  

  editButton(id: number, date: string, info: string) {
    const textarea = document.getElementById('info') as HTMLTextAreaElement;
    textarea.value = info;
    const inputdate = document.getElementById('date') as HTMLInputElement;
    inputdate.value = date;
    this.editingId = id;
    // (
    //   document.getElementById('edit-button') as HTMLButtonElement
    // ).style.visibility = 'visible';
  }

  // searchReminder(event){
  //   const tex= event.target.value;

  // }

  editReminder(id: number, date: string, info: string) {
    this.reminderService.editReminder(id, date, info).subscribe((response) => {
      this.reminders = response;

      this.getReminders();
      this.cleanTextArea();
      // (
      //   document.getElementById('edit-button') as HTMLButtonElement
      // ).style.visibility = 'hidden';
    });
  }
}
