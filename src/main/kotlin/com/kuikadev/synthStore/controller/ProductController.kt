package com.kuikadev.synthStore.controller

import com.kuikadev.synthStore.model.Product
import com.kuikadev.synthStore.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/products")
class ProductController {


    @Autowired
    lateinit var productRepository: ProductRepository

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping
    fun list(): List<Product> {
        return productRepository.findAll().toList()
    }

    @GetMapping("/appliedDiscount")
    fun listDiscount(): List<Product> {
        return productRepository.findAll().toList().map { product -> applyDiscount(product, 0.1.toBigDecimal()) }
    }

    @PostMapping
    fun add(@RequestBody product: Product): Product {
        return productRepository.save(product)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): Product {
        if(productRepository.existsById(id)) {
            val safeProduct = product.copy(id)
            return productRepository.save(safeProduct)
        }
        return Product()
    }

    @DeleteMapping("{id}")
    fun remove(@PathVariable id: Long) {
        if(productRepository.existsById(id)) {
            return productRepository.deleteById(id)
        }
    }

    fun applyDiscount(product: Product, discount: BigDecimal): Product {
        return product.copy(price = product.price - product.price * discount)
    }

}