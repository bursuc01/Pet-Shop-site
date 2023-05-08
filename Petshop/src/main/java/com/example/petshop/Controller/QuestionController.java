package com.example.petshop.Controller;

import com.example.petshop.Model.Question;
import com.example.petshop.Repository.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  This class manages the http requests for the Question model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class QuestionController {
    private final QuestionRepository repository;

    public QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<Question>
     *
     *  This method executes a get request and returns all available Questions
     */
    @GetMapping("/getQuestion")
    public List<Question> all() {
        return repository.findAll();
    }

    /**
     *
     * @param newQuestion Question
     * @return Question
     *
     *  This method executes a post request and creates a new Question
     */
    @PostMapping("/createQuestion")
    public Question newQuestion(@RequestBody Question newQuestion) {
        return repository.save(newQuestion);
    }

    /**
     *
     * @param id
     *
     * This method executes a delete request and deletes an existing Question
     */
    @DeleteMapping("/deleteQuestion")
    public void deleteQuestion(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newQuestion Question
     * @return Question
     *
     *  This method executes an update request and updates an existing Question
     */
    @PutMapping("/putQuestion")
    public Question updateQuestion(@RequestBody Question newQuestion){return repository.save(newQuestion);}
}
