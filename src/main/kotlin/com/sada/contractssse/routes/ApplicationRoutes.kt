package com.sada.contractssse.routes

import com.sada.contractssse.handler.ContractHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.TEXT_EVENT_STREAM
import org.springframework.web.reactive.function.server.router

/**
 * Routes class.
 * - /contracts : returns the list of contracts as SSE
 */
@Configuration
class ApplicationRoutes(private val contractHandler: ContractHandler) {

    @Bean
    fun routes() = router {
        (accept(TEXT_EVENT_STREAM) and "/contracts").nest({
            GET("/", contractHandler::getContracts)
        })
    }
}