package cz.xnevrela.ldg.api;

import cz.xnevrela.ldg.LdgApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = LdgApplication.class)
@AutoConfigureMockMvc
public class ContactRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void
    whenValidContactRequest_contactRequestIsSaved() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
            .post(ContactRequestController.ENDPOINT)
            .accept(MediaType.TEXT_HTML)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("policyNumber", "PolicyNumber")
            .param("name", "Aleš")
            .param("surname", "Nevřela")
            .param("request", "My contact request")
            .param("requestType", "3")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(model().hasNoErrors());
    }

    @Test
    public void
    whenEmptyContactRequest_validationErrorsAreReturned() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
            .post(ContactRequestController.ENDPOINT)
            .accept(MediaType.TEXT_HTML))
            .andExpect(status().isOk())
            .andExpect(view().name("EnterContactRequest"))
            .andExpect(model().errorCount(3))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "policyNumber", "NotBlank"))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "request", "NotBlank"))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "requestType", "NotNull"));
    }

    @Test
    public void
    whenInvalidContactRequest_validationErrorsAreReturned() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
            .post(ContactRequestController.ENDPOINT)
            .accept(MediaType.TEXT_HTML)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("policyNumber", "+-+")
            .param("name", "a1a")
            .param("surname", "2b2")
        )
            .andExpect(status().isOk())
            .andExpect(view().name("EnterContactRequest"))
            .andExpect(model().errorCount(5))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "policyNumber", "AlphaNumeric"))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "name", "Alphabetic"))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "surname", "Alphabetic"))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "request", "NotBlank"))
            .andExpect(model().attributeHasFieldErrorCode("contactRequest", "requestType", "NotNull"));
    }

}
