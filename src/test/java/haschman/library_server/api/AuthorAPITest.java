//package haschman.library_server.api;
//
//import haschman.library_server.api.model.AuthorDTO;
//import haschman.library_server.api.model.converter.AuthorToDTOConverter;
//import haschman.library_server.api.model.converter.AuthorToEntityConverter;
//import haschman.library_server.business.AuthorService;
//import haschman.library_server.business.EntityStateException;
//import haschman.library_server.domain.Author;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@WebMvcTest(AuthorController.class)
//public class AuthorAPITest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    AuthorService authorService;
//
//    @MockBean
//    AuthorToDTOConverter authorToDTOConverter;
//    @MockBean
//    AuthorToEntityConverter authorToEntityConverter;
//
//    @Test
//    public void createCONFLICTTest() throws Exception {
//        Author author = new Author(null, "Test", null, null);
//        Mockito.when(authorToDTOConverter.apply(author)).thenCallRealMethod();
//        Mockito.when(authorService.create(author)).thenThrow(EntityStateException.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/authors").content("{\"surname\"} : \"Test\""))
//                .andExpect(MockMvcResultMatchers.status().isConflict());
//    }
//}
