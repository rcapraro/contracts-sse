package com.sada.contractssse.domain

import java.time.LocalDateTime

/**
 * Contract data class.
 */
data class Contract(var id: Long, var produit:String, var dateEffet:LocalDateTime) {
}