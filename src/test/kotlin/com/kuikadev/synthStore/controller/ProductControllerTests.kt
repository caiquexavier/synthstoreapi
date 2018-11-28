package com.kuikadev.synthStore.controller

import com.kuikadev.synthStore.model.Product
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ProductControllerTests {

    @InjectMocks
    lateinit var productController: ProductController

    @Test
    fun testApplyDiscount() {
        val product = Product(1, "Test Product", "Testing", 1000.toBigDecimal(), "")
        val result = productController.applyDiscount(product, 0.1.toBigDecimal())
        assert(result.price == 900.0.toBigDecimal())
    }

    @Test
    fun testApplyDiscountHalfPrice() {
        val product = Product(2, "Test Product", "Testing", 1000.toBigDecimal(), "")
        val result = productController.applyDiscount(product, 0.5.toBigDecimal())
        assert(result.price == 500.0.toBigDecimal())
    }
}