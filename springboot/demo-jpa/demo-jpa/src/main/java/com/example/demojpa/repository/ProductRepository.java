package com.example.demojpa.repository;

import com.example.demojpa.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // 1. Tìm kiếm sản phẩm theo tên và sắp xếp theo count giảm dần
    @Query(nativeQuery = true, value = "select * from product where name = ?1 order by count desc")
    List<Product> findByNameOderByDesc(String name, Integer count);
    // 2.Tìm kiếm sản phầm có tên chưa ký tự, không phần biệt hoa thường (có phân trang)

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // 3.Sắp xếp các sản phẩm theo giá giảm dần (findAll(Pageable pageable))
    List<Product> orderByDesc(Double price, Sort sort);
    // 4.Sắp xếp các sản phẩm theo tên (A -> Z), có phân trang
    Page<Product> orderByName(String name, Sort sort, Pageable pageable);
    // 5.Sắp xếp sản phẩm theo count, có phân trang
    @Query("select p from product p order by p.count desc")
    Page<Product> orderByCount( Pageable pageable);
    // 6.Tìm kiếm sản phẩm theo brand nào đó và sắp xếp theo giá, có phân trang
    Page<Product> findByBrand(String brand, Pageable pageable);
    // 7.Đếm số lượng các sản phẩm theo brand
    long countByBrand(String brand);
    // 8.Tính tổng các sản phẩm còn lại trong kho theo brand
    long countProductByBrandGreaterthan(String brand, Integer count);
}
