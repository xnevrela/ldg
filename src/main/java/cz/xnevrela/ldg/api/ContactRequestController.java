package cz.xnevrela.ldg.api;

import cz.xnevrela.ldg.domain.ContactRequest;
import cz.xnevrela.ldg.repository.ContactRequestRepository;
import cz.xnevrela.ldg.repository.ContactRequestTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Handles {@link ContactRequest} endpoint operations
 */
@Controller
@RequestMapping("contact")
public class ContactRequestController {
    private static final Logger log = LoggerFactory.getLogger(ContactRequestController.class);

    private ContactRequestRepository contactRequestRepository;
    private ContactRequestTypeRepository requestTypeRepository;

    public ContactRequestController(ContactRequestRepository contactRequestRepository, ContactRequestTypeRepository requestTypeRepository) {
        this.contactRequestRepository = contactRequestRepository;
        this.requestTypeRepository = requestTypeRepository;
    }

    /**
     * Redirect to enter a new contact
     *
     * @return EnterContactRequest view
     */
    @GetMapping
    public ModelAndView enterContactRequest() {
        if (log.isTraceEnabled()) {
            log.trace("User opened enter contact request form");
        }

        ModelAndView model = new ModelAndView();

        model.addObject("requestTypes", requestTypeRepository.findAll());
        model.addObject("contactRequest", new ContactRequest());
        model.setViewName("EnterContactRequest");

        return model;
    }

    /**
     * Insert new contact request
     *
     * @return EnterContactRequest view
     */
    @PostMapping
    public ModelAndView insertContactRequest(@Valid ContactRequest contactRequest, BindingResult result, Model model) {
        if (log.isTraceEnabled()) {
            log.trace("User submitted new contact request");
        }

        if (result.hasErrors()) {
            if (log.isDebugEnabled()) {
                log.debug("Insert contact request failed %s", result.getAllErrors());
            }

            return new ModelAndView("EnterContactRequest", model.asMap());
        }

        contactRequestRepository.save(contactRequest);
        if (log.isTraceEnabled()) {
            log.trace("User inserted new contact request");
        }

        // reset contact request
        model.addAttribute("contactRequest", new ContactRequest());
        return new ModelAndView("EnterContactRequest", model.asMap());
    }

}
