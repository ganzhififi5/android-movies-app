package com.popularmovies.vpaliy.domain.interactor

import com.popularmovies.vpaliy.domain.entity.Actor
import com.popularmovies.vpaliy.domain.executor.BaseScheduler
import com.popularmovies.vpaliy.domain.repository.Repository
import com.popularmovies.vpaliy.domain.then
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetActor @Inject constructor(var repository: Repository, scheduler: BaseScheduler)
    :SingleInteractor<String,Actor>(scheduler){

    override fun buildUseCase(params: String?): Single<Actor> {
        return params then(repository::fetchActor)
                ?:Single.error(IllegalArgumentException())
    }
}