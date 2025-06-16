package com.mvp.product.controller;

import com.mvp.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  @GetMapping
  public List<Product> list() {
    return List.of(
      new Product(1L, "Widget", 9.99),
      new Product(2L, "Gadget", 19.99)
    );
  }
}