package com.br.produto.apirest.Controller

import com.br.produto.apirest.repositories.ProdutoRepository
import com.br.produto.apirest.services.ProdutoService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest extends Specification {
    public static final long codigo = 4345

    @Autowired
    MockMvc mvc

    @SpringBean
    ProdutoService produtoServiceMock = Mock()

    def "should list produto"() {
        expect:
            mvc.perform(MockMvcRequestBuilders.get("/produto"))
            .andExpect(status().isOk())
    }

    def "should list produto by codigo"() {
        expect:
        mvc.perform(MockMvcRequestBuilders.get("/produto/${codigo}"))
                .andExpect(status().isOk())
                .andReturn()
    }

    def "should return status code 2xx when update produto by codigo"() {
        expect:
            mvc.perform(MockMvcRequestBuilders.put("/produto/${codigo}")
                    .characterEncoding("UTF-8")
                    .content("{\n" +
                            "\t\"codigo\": 3344,\n" +
                            "\t\"nome\": \"CDB\",\n" +
                            "\t\"classesInvestimento\": [\n" +
                            "\t\t{\n" +
                            "\t\t\t\"codigo\": 1234,\n" +
                            "\t\t\t\"nome\": \"Pos Fixado\",\n" +
                            "\t\t\t\"risco\": 5\n" +
                            "\t\t},\n" +
                            "\t\t{\n" +
                            "\t\t\t\"codigo\": 4321,\n" +
                            "\t\t\t\"nome\": \"CDB\",\n" +
                            "\t\t\t\"risco\": 5\n" +
                            "\t\t}\n" +
                            "\t]\n" +
                            "}")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn()
    }

    def "should return status code 2xx when save produto"() {
        expect:
            mvc.perform(MockMvcRequestBuilders.post("/produto")
                    .characterEncoding("UTF-8")
                    .content("{\n" +
                            "\t\"codigo\": 3344,\n" +
                            "\t\"nome\": \"CDB\",\n" +
                            "\t\"classesInvestimento\": [\n" +
                            "\t\t{\n" +
                            "\t\t\t\"codigo\": 1234,\n" +
                            "\t\t\t\"nome\": \"Pos Fixado\",\n" +
                            "\t\t\t\"risco\": 5\n" +
                            "\t\t},\n" +
                            "\t\t{\n" +
                            "\t\t\t\"codigo\": 4321,\n" +
                            "\t\t\t\"nome\": \"CDB\",\n" +
                            "\t\t\t\"risco\": 5\n" +
                            "\t\t}\n" +
                            "\t]\n" +
                            "}")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andReturn()
    }

    def "should delete produto by codigo"() {
        expect:
        mvc.perform(MockMvcRequestBuilders.delete("/produto/${codigo}"))
                .andExpect(status().isOk())
                .andReturn()
    }

    def "should delete all"() {
        expect:
        mvc.perform(MockMvcRequestBuilders.delete("/produto"))
                .andExpect(status().isOk())
                .andReturn()
    }

//    @Autowired
//    private ProdutoController controller
//
//    @Autowired
//    ProdutoService produtoService
//
//    @Autowired
//    ProdutoRepository produtoRepository
//    def "should context load return all beans created" () {
//        expect:
//            controller
//            produtoService
//            produtoRepository
//    }
//
//    @TestConfiguration
//    static class MockConfig {
//        def detachedMockFactory = new DetachedMockFactory()
//
//        @Bean
//        ProdutoRepository produtoRepository() {
//            return detachedMockFactory.Stub(ProdutoRepository)
//        }
//
//        @Bean
//        ProdutoService produtoService() {
//            return detachedMockFactory.Stub(ProdutoRepository)
//        }
//    }
}