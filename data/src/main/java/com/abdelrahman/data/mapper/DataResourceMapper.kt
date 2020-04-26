package com.abdelrahman.data.mapper

import com.abdelrahman.data.resource.DataResource
import com.abdelrahman.domain.resource.DomainResource
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class DataResourceMapper<INPUT, OUTPUT> @Inject constructor(
    private val mapper: Mapper<INPUT, OUTPUT>
) {
    fun map(input: DataResource<INPUT>): DomainResource<OUTPUT> {
        return when (input.status) {
            DataResource.Status.SUCCESS -> DomainResource.success(mapper.map(input = input.data))
            else -> DomainResource.error(input.message, input.errorCode, input.errorExtras)
        }
    }

    fun mapList(input: DataResource<List<INPUT>>): DomainResource<List<OUTPUT>> {
        return when (input.status) {
            DataResource.Status.SUCCESS -> DomainResource.success(mapper.map(input.data))
            else -> DomainResource.error(input.message, input.errorCode, input.errorExtras)
        }
    }
}