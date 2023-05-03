## Pet shop online
>Ianis Oprian
## About the project
- This project is about creating an online supply store for pets. The site offers such supplies: leashes, cat and dog food, collars, toys, and many other things, a login/register functionality, so that the user can view the prices available on the site for the available products but that he/she cannot use the site for ordering the products nor selecting them for the shopping cart unless he/she creates an account. The selected products will be added to the to the shopping cart available in the top right corner of the site, where he can view a list every item he wants to purchase, quantity and final price.
- There is an information rubric for users that have where you will be able to ask questions about common curiosities about pets, questions that are categorized by the animals themselves. The main categories are: dogs, cats, reptiles, fish, birds, and others.
- In order to manage the site there will be an administrator account that can add, remove and modify offers on the site so that the site it is up to date with it's stock and changing prices. Every time a user will select a product, it's quantity will be updated, and if he/she changes his/her mind about the product, the quantity will update again to the value it was before the order placement.

## Project structure
The project is structured in 3 main packages that deal with the backend part: 
- Models : the classes that help store information in the database and have a huge role in creating the endpoints. The classes conect with the help of annotaions that have additional practicality, resulting in shorter and more impactful code
```sh
//example of a model class for admin
@Entity
@Table(name = "Admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admin_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
```
The annotations help create getters, setters, and different kind of constructors. 
- Repository can easily perform common database operations on our entities without having to write boilerplate code for each operation. This saves time and reduces the chance of errors. We have different type of interfaces for each model, and every interface implements JPARepository with the generics of it's own model.
``` sh
//example of Admin Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
```
- Controller has the implementations of the post, delte, put and get endpoints. It uses the Repository created for it's model and there are implementations for every model as well. This is the package that has the actual code for the operations we need for our site such as: adding to cart or creating a user.
``` sh
//example of admin controller
@RestController
public class AdminController {
    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getAdmin")
    public List<Admin> all() {
        return repository.findAll();
    }

    @PostMapping("/createAdmin")
    public Admin newAdmin(@RequestBody Admin newAdmin) {
        return repository.save(newAdmin);
    }

    @DeleteMapping("/deleteAdmin")
    public void deleteAdmin(@RequestBody int id) {
        repository.deleteById(id);
    }

    @PutMapping("/putAdmin")
    public Admin updateAdmin(@RequestBody Admin newAdmin){return repository.save(newAdmin);}
}
```

## Project endpoints
In order for this project to work we need to have a multitude of endpoints. For my site I have them categorized by
the kind of model it modifies: Admin, Cart, Category, Order, OrderDetail, Product, Question and User. 
We can find:
- Get request: it retrieves all data available for a model: for table Product it retrieves all products that exist.
```sh
    //example for user model
    @GetMapping("/getUser")
    public List<User> all() {
        return repository.findAll();
    }
```
- Post request: it creates a new model by specifying all the fields needed for that model to be created.
 ```sh
    //example for user model
    @PostMapping("/createUser")
    public User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }
```
- Delete rquest: it deletes a table in your data base by specifying the id fot that table.
```sh
    //example for user model
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody int id) {
        repository.deleteById(id);
    }
```
- Put request: it updates a table with the fields you require.
```sh
    //example for user model
    @PutMapping("/putUser")
    public User updateUser(@RequestBody User newUser){return repository.save(newUser);}
```

I added some more endpoints that satisfy my specific needs like adding a Product to an Order. If a client wants to create an order, the site will automatically add the product selected to the order with an id that is processed automatically as well. 




 