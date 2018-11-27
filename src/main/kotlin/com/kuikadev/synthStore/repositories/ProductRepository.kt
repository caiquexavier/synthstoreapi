package com.kuikadev.synthStore.repositories

import com.kuikadev.synthStore.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long>