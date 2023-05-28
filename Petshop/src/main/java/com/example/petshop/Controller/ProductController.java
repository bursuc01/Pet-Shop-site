package com.example.petshop.Controller;
import com.example.petshop.Model.Order;
import com.example.petshop.Model.Product;
import com.example.petshop.Model.ProductOrdered;
import com.example.petshop.Model.response.AddToOrder;
import com.example.petshop.Model.response.FetchEntities;
import com.example.petshop.Repository.OrderRepository;
import com.example.petshop.Repository.ProductOrderedRepository;
import com.example.petshop.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 *  This class manages the http requests for the product model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class ProductController
{
    private final ProductRepository repository;
    private final OrderRepository orderRepository;
    private final ProductOrderedRepository productOrderedRepository;

    public ProductController(ProductRepository repository, OrderRepository orderRepository, ProductOrderedRepository productOrderedRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
        this.productOrderedRepository = productOrderedRepository;
    }

    /**
     *
     * @return List<Product>
     *
     *  This method executes a get request and returns all available Product
     */
    @GetMapping("/getProduct")
    public ResponseEntity<FetchEntities<Product>> all() {
        FetchEntities<Product> fetchEntities = new FetchEntities<>();
        fetchEntities.setFetched(repository.findAll());
        return new ResponseEntity<>(fetchEntities, HttpStatus.OK);
    }
    /**
     *
     * @param newProduct Product
     * @return Product
     *
     *  This method executes a post request and creates a new Product
     */
    @PostMapping("/createProduct")
    public Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    /**
     *
     * @param id
     *
     *  This method executes a delete request and deletes an existing Product
     */
    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * * @param newProduct Product
     * @return Product
     *
     *  This method executes an update request and updates an existing Product
     */
    @PutMapping("/putProduct")
    public Product updateProduct(@RequestBody Product newProduct){return repository.save(newProduct);}

    /**
     *
     * @param addToOrder
     *
     *  This method takes the id of the requested item and adds it to an existing order by providing order id
     */
    @PostMapping("/addToOrder")
    public void addToOrder(@RequestBody AddToOrder addToOrder) throws Exception {
        int qty = addToOrder.getQty();
        int id = addToOrder.getProduct_id();
        int idOrder = addToOrder.getOrder_id();
        Order order;
        Product product;
        if(orderRepository.findById(idOrder).isPresent() && repository.findById(id).isPresent()){
            order = orderRepository.findById(idOrder).get();
            product = repository.findById(id).get();
            if(product.getQuantity() - qty >= 0) {
                product.setQuantity(product.getQuantity() - qty);
                productOrderedRepository.save(new ProductOrdered(qty, order.getOrder_id(), product.getProduct_id()));
                order.setTotalPrice(order.getTotalPrice() + product.getPrice() * qty);
                orderRepository.save(order);
            }
            else {
                throw new Exception("Not enough in stock");
            }
        }
    }
}