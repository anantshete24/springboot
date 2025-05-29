
package com.lcwd.db.postgres.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.db.postgres.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	Product findByName(String title);
}
