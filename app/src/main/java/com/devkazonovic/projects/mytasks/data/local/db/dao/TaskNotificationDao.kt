package com.devkazonovic.projects.mytasks.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.devkazonovic.projects.mytasks.data.local.db.entity.TaskNotificationEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface TaskNotificationDao : BaseCrudDao<TaskNotificationEntity> {

    @Transaction
    @Query("UPDATE task_notification SET state=:state WHERE id=:id")
    fun updateState(id: Int, state: String): Completable

    @Query("DELETE FROM task_notification WHERE id = :id")
    fun deleteById(id: Int): Completable

    @Query("SELECT * FROM task_notification WHERE id = :id")
    fun findTaskNotificationById(id: Int): Single<TaskNotificationEntity>
}