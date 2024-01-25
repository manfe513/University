package com.vasiliev.mymeds.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import com.vasiliev.mymeds.MainActivity
import com.vasiliev.mymeds.data.model.Course
import com.vasiliev.mymeds.data.model.Drug
import com.vasiliev.mymeds.data.model.User
import com.vasiliev.mymeds.helper.AlarmSetter
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

object Repo {

    val db = Firebase.firestore

    fun addCourse(course: Course) {
        db.collection(User.COLLECTION_NAME)
            .add(course)

        AlarmSetter.set(MainActivity.appContext!!, course)
    }

    fun editCourse(course: Course) {
        db.collection(Course.COLLECTION_NAME)
            .document(course.id)
            .update(
                mapOf(
                    Course.FIELD_DRUG to course.drug,
                    Course.FIELD_DRUG_FOOD_COMPATIBILITY to course.foodCompatibility,
                    Course.FIELD_DATE_START to course.dateStart,
                    Course.FIELD_DATE_END to course.dateEnd
                )
            )
    }

    fun deleteCourse(course: Course) {
        db.collection(Course.COLLECTION_NAME)
            .document(course.id)
            .delete()
    }

    fun getCourse(courseId: String): Flow<Course?> = callbackFlow {
        db.collection(Course.COLLECTION_NAME)
            .document(courseId)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                val course = documentSnapshot.toObject<Course>()
                trySendBlocking(course)
            }
    }

    fun getCourses(userId: String): List<Course> = db
        .collection(User.COLLECTION_NAME)
        .document(userId)
        .collection(Course.COLLECTION_NAME)
        .get()
        .result
        .map { it.toObject(Course::class.java) }

    fun getDrug(drugId: String): Drug? = db.collection(Drug.)
}