package com.mnyan.githubapp.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mnyan.githubapp.R
import com.mnyan.githubapp.data.model.Reminder
import com.mnyan.githubapp.databinding.ActivitySettingsBinding
import com.mnyan.githubapp.preference.ReminderPreference
import com.mnyan.githubapp.receiver.AlarmReceiver

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var reminder: Reminder
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reminderPreference = ReminderPreference(this)
        if (reminderPreference.getReminder().isReminded){
            binding.switch1.isChecked = true
        } else {
            binding.switch1.isChecked = false
        }

        alarmReceiver = AlarmReceiver()

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked){
                    saveReminder(true)
                    alarmReceiver.setRepeatingAlarm(this,"Repeating Alarm","07:45","Github Reminder")
                }else {
                    saveReminder(false)
                    alarmReceiver.cancelAlarm(this)
                }
            }
        }

    private fun saveReminder(state: Boolean) {
        val reminderPreference = ReminderPreference(this)
        reminder = Reminder()

        reminder.isReminded = true
        reminderPreference.setReminder(reminder)
    }
}