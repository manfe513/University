package com.vasiliev.mymeds.courses

import DatePickerWithDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.core.os.ConfigurationCompat
import androidx.navigation.NavController
import com.vasiliev.mymeds.data.Repo
import com.vasiliev.mymeds.model.Course
import com.vasiliev.mymeds.model.Drug
import com.vasiliev.mymeds.model.DrugType
import com.vasiliev.mymeds.model.DrugUseType
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun AddCourse(
    navController: NavController,
    repo: Repo
) {

    var drugName = ""
    var drugDescr = ""
    var drugType = DrugType.TABLETKI
    var drugUseType = DrugUseType.POSLE_EDI
    var dateStart: Date = Date()
    var dateEnd: Date = Date()

    val locale = ConfigurationCompat.getLocales(LocalConfiguration.current)[0]

    Column {
        Text(text = "Добавление курса")
        TextField(
            label = { Text(text = "Название препарата") },
            value = drugName,
            onValueChange = { drugName = it }
        )
        TextField(
            label = { Text(text = "Описание препарата") },
            value = drugDescr,
            onValueChange = { drugDescr = it }
        )
        DropdownMenu(
            expanded = false,
            onDismissRequest = {}
        ) {
            // adding items
            DrugType.entries.forEach { _drugType ->
                DropdownMenuItem(
                    text = { Text(text = _drugType.name) },
                    onClick = { drugType = _drugType }
                )
            }
        }
        DropdownMenu(
            expanded = false,
            onDismissRequest = {}
        ) {
            // adding items
            DrugUseType.entries.forEach { _drugUseType ->
                DropdownMenuItem(
                    text = { Text(text = _drugUseType.name) },
                    onClick = { drugUseType = _drugUseType }
                )

            }
        }

        DatePickerWithDialog(
            placeholder = {
                Text(text = "Дата начала")
            },
            dateFormatter = {
                DateTimeFormatter.ofPattern("yyyy MMM dd", locale).format(it)
            },
            value = LocalDate.now()
        ) {
            dateStart = Date(it!!.toEpochDay())
        }

        DatePickerWithDialog(
            placeholder = {
                Text(text = "Дата окончания")
            },
            dateFormatter = {
                DateTimeFormatter.ofPattern("yyyy MMM dd", locale).format(it)
            },
            value = LocalDate.now()
        ) {
            dateEnd = Date(it!!.toEpochDay())
        }
    }
    ElevatedButton(onClick = {
        repo.addCourse(
            Course(
                drug = Drug(
                    name = drugName,
                    description = drugDescr,
                    drugType = drugType
                ),
                drugUseType = drugUseType,
                dateStart = dateStart,
                dateEnd = dateEnd
            )
        )
    }) {
        Text(text = "Сохранить")
    }
}
