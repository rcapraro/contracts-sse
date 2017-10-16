package com.sada.contractssse.handler

import com.sada.contractssse.domain.Contract
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

@Component
/**
 * Contract Handler.
 * - /getContracts: return the list of contracts
 */
class ContractHandler {

    fun getContracts(rea: ServerRequest): Mono<ServerResponse> {

        val users = Flux.just(
                Contract((0L..1000).random(), "AUTO", LocalDateTime.now()),
                Contract((0L..1000).random(), "IMMEUBLE", LocalDateTime.now()),
                Contract((0L..1000).random(), "MRP", LocalDateTime.now()))

        val contractStream = Flux.zip(
                Flux.interval(Duration.ofMillis(4000)),
                users.repeat())
                .map { it.t2 }

        return ok().bodyToServerSentEvents(contractStream)
    }

    fun ClosedRange<Long>.random() = Random().nextLong();

}