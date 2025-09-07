package com.inspireapi.springbootexercise;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.inspireapi.Exception.InspireSessionNotFound;
import com.inspireapi.Model.InspireSession;
import com.inspireapi.Model.Module;
import com.inspireapi.Model.ModuleType;
import com.inspireapi.Repository.InspireSessionRepository;
import com.inspireapi.Repository.ModuleRepository;
import com.inspireapi.Service.InspireSessionService;
import com.inspireapi.Service.InspireSessionServiceImpl;


@DisplayName("InspireSessionServiceTest Basic Tests Suite")
public class InspireSessionServiceTest {

   private ModuleRepository mockModuleRepository;
   private InspireSessionRepository mockInspireSessionRepository;
   private InspireSessionService mockInspireSessionService;

   private InspireSession inspireSessionOne;
   private InspireSession inspireSessionTwo;

    
   @BeforeEach
    public void setUp() {
        mockModuleRepository = Mockito.mock(ModuleRepository.class);
        mockInspireSessionRepository = Mockito.mock(InspireSessionRepository.class);
        mockInspireSessionService = new InspireSessionServiceImpl (mockInspireSessionRepository, mockModuleRepository);
        inspireSessionOne = new InspireSession(
            UUID.randomUUID(),
            "Breathe in, hold for 4 min, breathe out. Do this 5 times.",
            "In Java, The meaning of Final keyword is not final. It has different meanings in java. It can be Final class, Final method, Final field or Final variable.",
            "Success is never final, failure is never fatal. It is courage that counts. - John Wooden.",
            Instant.now()
        );

        inspireSessionTwo = new InspireSession(
            UUID.randomUUID(),
            "Complete five full breaths cycle. Each breath cycle (inhale and exhale) should last about 12 seconds.",
            "Hiding internal data from the outside world, and accessing it only through publicly exposed methods is known as data Encapsulation.",
            "Hide nothing, for time, which sees all and hears all, exposes all. - Sophocles",
            Instant.now()
        );

    }

    @DisplayName("return empty list when no Inspire sessions exist")
    @Test
    void testGetAllInspireSessionsInitiallyEmpty(){
        Mockito.when(mockInspireSessionRepository.findAll()).thenReturn(List.of());
        assertTrue(mockInspireSessionService.getAllSessions().isEmpty());
    }
    
    @DisplayName("return all Inspire sessions")
    @Test
    void testGetAllInspireSessionsAfterAdding() {
        Mockito.when(mockInspireSessionRepository.save(Mockito.any(InspireSession.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockInspireSessionRepository.findAll()).thenReturn(List.of(inspireSessionOne, inspireSessionTwo));
        mockInspireSessionService.createInspireSession(inspireSessionOne);
        mockInspireSessionService.createInspireSession(inspireSessionTwo);

        List<InspireSession> inspireSessions = mockInspireSessionService.getAllSessions();

        assertEquals(2, inspireSessions.size());
        assertTrue(inspireSessions.contains(inspireSessionOne));
        assertTrue(inspireSessions.contains(inspireSessionTwo));
    }

    @DisplayName("return the Inspire session with the specific ID")
    @Test
    void testGetExistingInspireSessionById(){
        Mockito.when(mockInspireSessionRepository.save(Mockito.any(InspireSession.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockInspireSessionRepository.findById(inspireSessionOne.getSessionId())).thenReturn(Optional.of(inspireSessionOne));

        InspireSession inspireSessionFound = mockInspireSessionService.getSessionById(inspireSessionOne.getSessionId());

        assertNotNull(inspireSessionFound);
        assertEquals(inspireSessionOne, inspireSessionFound);
        Mockito.verify(mockInspireSessionRepository).findById(inspireSessionOne.getSessionId());
    }

    @DisplayName("return the InspireSessionNotFound exception was a non existing ID is passed")
    @Test
    void testGetNonExistingInspireSessionById() {
        UUID nonExistingId = UUID.fromString("f81d40fae-7dec-11d0-a70065-00e68bf6");
        Mockito.when(mockInspireSessionRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        try {
            mockInspireSessionService.getSessionById(nonExistingId);
            fail("Failed because this is a not existing ID, the InspireSessionNotFound exception will be thrown");
        } catch (InspireSessionNotFound err) {
            assertEquals("Inspire session with ID " + nonExistingId + " not found", err.getMessage());
        }
    }


    @DisplayName("return the new Inspire session")
    @Test
    void testCreateInspireSession() {
        UUID randomUuid = UUID.randomUUID();
        InspireSession inspireSessionThree = new InspireSession(
            randomUuid, 
            "Breathe test content", 
            "Learn test content", 
            "Quote test content", 
            Instant.now()
        );
        Mockito.when(mockInspireSessionRepository.save(Mockito.any(InspireSession.class))).thenReturn(inspireSessionThree);

        InspireSession newInspireSession = mockInspireSessionService.createInspireSession(inspireSessionThree);

        assertNotNull(newInspireSession);
        assertEquals(randomUuid, newInspireSession.getSessionId());
        assertEquals(inspireSessionThree, newInspireSession);
        assertEquals("Breathe test content", newInspireSession.getBreatheContent());
        assertEquals("Learn test content", newInspireSession.getLearnContent());
        assertEquals("Quote test content", newInspireSession.getQuoteContent());

        Mockito.verify(mockInspireSessionRepository).save(inspireSessionThree);
    }

    @DisplayName("")
    @Test
    void testCreateInspireSessionFromModules() {
        Module breatheModule = new Module(
            UUID.randomUUID(),
            ModuleType.BREATHE,
            "Breathe test content"
        );
        Module learnModule = new Module(
            UUID.randomUUID(),
            ModuleType.LEARN,
            "Learn test content"
        );
        Module quoteModule = new Module(
            UUID.randomUUID(),
            ModuleType.QUOTE,
            "Quote test content"
        );

        Mockito.when(mockModuleRepository.findByModuleType(ModuleType.BREATHE)).thenReturn(List.of(breatheModule));
        Mockito.when(mockModuleRepository.findByModuleType(ModuleType.LEARN)).thenReturn(List.of(learnModule));
        Mockito.when(mockModuleRepository.findByModuleType(ModuleType.QUOTE)).thenReturn(List.of(quoteModule));

        Mockito.when(mockInspireSessionRepository.save(Mockito.any(InspireSession.class))).thenAnswer(invocation -> invocation.getArgument(0));

        InspireSession newInspireSessionFromModules = mockInspireSessionService.createInspireSessionFromModules();

        assertNotNull(newInspireSessionFromModules);
        assertEquals("Breathe test content", newInspireSessionFromModules.getBreatheContent());
        assertEquals("Learn test content", newInspireSessionFromModules.getLearnContent());
        assertEquals("Quote test content", newInspireSessionFromModules.getQuoteContent());
        
        Mockito.verify(mockModuleRepository).findByModuleType(ModuleType.BREATHE);
        Mockito.verify(mockModuleRepository).findByModuleType(ModuleType.LEARN);
        Mockito.verify(mockModuleRepository).findByModuleType(ModuleType.QUOTE);
        Mockito.verify(mockInspireSessionRepository).save(Mockito.any(InspireSession.class));
    }

    @DisplayName("Updating existing Inspire session")
    @Test
    void testUpdatingExistingInspireSession() {
        Mockito.when(mockInspireSessionRepository.save(Mockito.any(InspireSession.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockInspireSessionRepository.findById(inspireSessionOne.getSessionId())).thenReturn(Optional.of(inspireSessionOne));

        InspireSession updatedInspireSession = new InspireSession(
            inspireSessionOne.getSessionId(),
            "Update to breathe content",
            "Update to learn content",
            "Update to quote content",
            inspireSessionOne.getCreatedAt()
        );

        InspireSession resultInspireSession = mockInspireSessionService.updateInspireSession(inspireSessionOne.getSessionId(), updatedInspireSession);

        assertNotNull(resultInspireSession);
        assertEquals("Update to breathe content", resultInspireSession.getBreatheContent());
        assertEquals("Update to learn content", resultInspireSession.getLearnContent());
        assertEquals("Update to quote content", resultInspireSession.getQuoteContent());
        
        Mockito.verify(mockInspireSessionRepository).findById(inspireSessionOne.getSessionId());
        Mockito.verify(mockInspireSessionRepository).save(inspireSessionOne);
    }

}