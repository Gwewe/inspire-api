package com.inspireapi.springbootexercise;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.inspireapi.Service.InspireSessionService;


@DisplayName("InspireAPI Basic Tests Suite")
public class InspireAPITests {
    @Mock
        InspireSessionService inspireSessionService;

    @Test
    @DisplayName("Return a existing session with the 3 modules")
    public void GetAnExistingSessionWithThreeModules() {
        //KISS version 1
        //Arrange
        String breatheModuleOne = "Breathe in.... Breathe out...., Breathe in.... Breathe out....";
        String learnModuleOne = "Spring Security handles Authentication, Authorisation, Security Context (stores user’s identity and roles). Spring Security protects against common threats such as Cross-Site Request Forgery (CSRF), support password encoding and uses filter chain.";
        String quotesModuleOne = "We work so hard, not to change the world but to prevent the world from changing us. - Unknown author";
        InspireSessionService inspireSessionOne = new InspireSessionService();

        //Act
        inspireSessionOne.addModule(breatheModuleOne);
        inspireSessionOne.addModule(learnModuleOne);
        inspireSessionOne.addModule(quotesModuleOne);

        //Assert
        assertNotNull(inspireSessionOne);
        assertEquals(List.of(breatheModuleOne, learnModuleOne, quotesModuleOne), inspireSessionOne.getModules());
    }

}