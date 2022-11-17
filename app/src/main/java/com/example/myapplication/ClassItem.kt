package com.example.myapplication

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class ClassItem(
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completeDate: LocalDate?,
    var id: UUID = UUID.randomUUID()
) {


}