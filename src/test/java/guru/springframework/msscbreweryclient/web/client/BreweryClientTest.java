package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDTO;
import guru.springframework.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDTO);
    }

    @Test
    void saveNewBeer(){

        BeerDTO beerDTO = BeerDTO.builder().beerName("Test Beer").build();

        URI uri = breweryClient.saveNewBeer(beerDTO);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer(){

        BeerDTO beerDTO = BeerDTO.builder().beerName("Test Beer").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDTO);
    }

    @Test
    void saveNewCustomer(){

        CustomerDTO customerDTO = CustomerDTO.builder().name("Test Customer").build();

        URI uri = breweryClient.saveNewCustomer(customerDTO);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer(){

        CustomerDTO customerDTO = CustomerDTO.builder().name("Test Customer").build();

        breweryClient.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void deleteCustomer(){
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}