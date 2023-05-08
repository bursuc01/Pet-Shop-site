package com.example.petshop;

import com.example.petshop.Controller.AdminController;
import com.example.petshop.Model.Admin;
import com.example.petshop.Repository.AdminRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminRepository adminRepository;

//    @Test
//    public void testGetAllAdmins() throws Exception {
//        // Arrange
//        Admin admin1 = new Admin(1, "admin1", "password1");
//        Admin admin2 = new Admin(2, "admin2", "password2");
//        List<Admin> admins = Arrays.asList(admin1, admin2);
//        Mockito.when(adminRepository.findAll()).thenReturn(admins);
//
//        // Act
//        mockMvc.perform(get("/getAdmin"))
//                .andExpect(status().isOk())
//                .andExpect( jsonPath("$[0].username", is("admin1")))
//                .andExpect( jsonPath("$[1].username", is("admin2")));
//    }

}
