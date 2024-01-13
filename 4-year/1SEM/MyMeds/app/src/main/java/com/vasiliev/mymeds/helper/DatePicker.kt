import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.ConfigurationCompat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDialog(
    value: LocalDate?,
    dateFormatter: (LocalDate) -> String,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    dateValidator: (Long) -> Boolean = { true },
    onChange: (LocalDate?) -> Unit
) {
    var openDialog by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = value?.atStartOfDay()?.toEpochSecond(ZoneOffset.UTC)
            ?.times(1000)
    )

    Box {
        TextField(
            value = value?.let(dateFormatter).orEmpty(),
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            label = placeholder ?: { DatePickerDefaults.DatePickerTitle(datePickerState) },
            colors = TextFieldDefaults.textFieldColors(),
            trailingIcon = {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = ""
                )
            })

        Box(
            Modifier
                .clickable(enabled = enabled) { openDialog = true }
                .matchParentSize()) {
            // This Box goes over the TextField allowing it to mask it
        }
    }

    if (openDialog) {
        val confirmEnabled by remember { derivedStateOf { datePickerState.selectedDateMillis != null } }
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                        onChange(datePickerState.selectedDateMillis?.let {
                            Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
                        })
                    },
                    enabled = enabled && confirmEnabled
                ) {
                    Text(stringResource(id = android.R.string.ok))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text(stringResource(id = android.R.string.cancel))
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                dateValidator = dateValidator,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DatePickerPreview() {
    val locale = ConfigurationCompat.getLocales(LocalConfiguration.current)[0]
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DatePickerWithDialog(
            dateFormatter = {
                DateTimeFormatter.ofPattern("yyyy MMM dd", locale).format(it)
            },
            value = LocalDate.of(2022, 10, 20),
            placeholder = { Text("Custom placeholder") }) {
        }
        DatePickerWithDialog(
            dateFormatter = {
                DateTimeFormatter.ofPattern("yyyy MMM dd", locale).format(it)
            },
            value = LocalDate.of(2022, 10, 20)
        ) {
        }
        DatePickerWithDialog(
            enabled = false,
            dateFormatter = { it.toString() },
            value = LocalDate.of(2022, 10, 20),
            placeholder = {
                Text(text = "Выберите дату")
            }) {
        }
    }
}