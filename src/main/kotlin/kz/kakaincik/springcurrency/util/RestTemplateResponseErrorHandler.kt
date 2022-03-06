package kz.kakaincik.springcurrency.util

import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.ResponseErrorHandler

@Component
class RestTemplateResponseErrorHandler : ResponseErrorHandler{
    override fun hasError(response: ClientHttpResponse): Boolean =
        response.statusCode.isError

    override fun handleError(response: ClientHttpResponse) {
        when(response.statusCode) {
            HttpStatus.NOT_FOUND -> throw HttpClientErrorException(HttpStatus.NOT_FOUND)
            else -> throw HttpClientErrorException(HttpStatus.BAD_REQUEST)
        }
    }
}