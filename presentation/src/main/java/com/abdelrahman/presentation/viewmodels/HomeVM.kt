package com.abdelrahman.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.usecase.UserInfoUseCase
import com.abdelrahman.presentation.mapper.PresentationResourceMapper
import com.abdelrahman.presentation.model.ResponseWrapperUi
import com.abdelrahman.presentation.qualifier.UserId
import com.abdelrahman.presentation.resource.PresentationResource
import io.reactivex.functions.Consumer
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
class HomeVM @Inject internal constructor(
    @UserId private val userId: String,
    private val mapper: PresentationResourceMapper<ResponseWrapperDomain, ResponseWrapperUi>,
    private val userInfoUseCase: UserInfoUseCase
) : BaseViewModel() {
    private val userInfoLiveData: MutableLiveData<PresentationResource<ResponseWrapperUi>> = MutableLiveData()

    //    val userInfoResource: LiveData<PresentationResource<ResponseWrapperUi>>
//        get() = userInfoUseCase.buildUseCase(userId)
//            .map { mapper.map(it) }
//            .map { PresentationResource.success(it) }
//            .doOnSubscribe(Consumer { PresentationResource.loading<>() })
//            .subscribe()
//            .toFlowable(BackpressureStrategy.LATEST)
//            .toLiveData()
    fun requestUserInfo() {
        execute(
            loadingConsumer = Consumer { userInfoLiveData.postValue(PresentationResource.loading()) },
            successConsumer = Consumer<PresentationResource<ResponseWrapperUi>> { response ->
                userInfoLiveData.value = response
            },
            throwableConsumer = Consumer { throwable ->
                userInfoLiveData.value = PresentationResource.domainError(throwable = throwable)
            },
            useCase = userInfoUseCase.buildUseCase(userId).map(mapper::map)
        )
    }
    fun getUserInfo(): LiveData<PresentationResource<ResponseWrapperUi>>{
        return userInfoLiveData
    }
}