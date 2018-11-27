package com.kuikadev.synthStore.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Product(
        @Id
        @GeneratedValue
        @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
        val id: Long = 0L,
        val title: String = "",
        val description: String = "",
        val price: BigDecimal = BigDecimal.ZERO
)