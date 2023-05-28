package com.example.petshop.Controller;
import com.example.petshop.Model.ProductOrdered;
import com.example.petshop.Model.response.FetchEntities;
import com.example.petshop.Repository.ProductOrderedRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 *  This class manages the http requests for the product model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class ProductOrderedController
{
    private final ProductOrderedRepository repository;

    public ProductOrderedController(ProductOrderedRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<ProductOrdered>
     *
     *  This method executes a get request and returns all available ProductOrdered
     */
    @GetMapping("/getProductOrdered")
    public ResponseEntity<FetchEntities<ProductOrdered>> all() {
        FetchEntities<ProductOrdered> fetchEntities = new FetchEntities<>();
        fetchEntities.setFetched(repository.findAll());
        return new ResponseEntity<>(fetchEntities, HttpStatus.OK);
    }
    /**
     *
     * @param newProduct ProductOrdered
     * @return ProductOrdered
     *
     *  This method executes a post request and creates a new ProductOrdered
     */
    @PostMapping("/createProductOrdered")
    public ProductOrdered newProduct(@RequestBody ProductOrdered newProduct) {
        return repository.save(newProduct);
    }

    /**
     *
     * @param id
     *
     *  This method executes a delete request and deletes an existing ProductOrdered
     */
    @DeleteMapping("/deleteProductOrdered")
    public void deleteProduct(@RequestBody int id) {
        repository.deleteById(id);
    }

}