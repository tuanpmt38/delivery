package shippo.vn.delivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import shippo.vn.delivery.TestUtils;
import shippo.vn.delivery.model.MerchantPickupAddress;
import shippo.vn.delivery.service.MerchantPickupAddressService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(MerchantPickupAddressController.class)
public class MerchantPickupAddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MerchantPickupAddressService merchantPickupAddressService;

    @InjectMocks
    private MerchantPickupAddressController merchantPickupAddressController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(merchantPickupAddressController)
                .build();
    }

    private final String URL = "/pickup_address/";


    @Test
    public void testGetMerchantPickupAddressById() throws Exception {
        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress(
                1, true, 3, 1, "Số nhà 178 ngõ 126 phố Không Mùa", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        when(merchantPickupAddressService.findById(1)).thenReturn(Optional.of(merchantPickupAddress));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(URL + "{id}", new Integer(1)).accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

        // verify that service method was called once.
        verify(merchantPickupAddressService).findById(any(Integer.class));

        MerchantPickupAddress resultMerchantPickupAddress = TestUtils.jsonToObject(result.getResponse().getContentAsString(), MerchantPickupAddress.class);
        assertNotNull(resultMerchantPickupAddress);
        assertEquals(1l, resultMerchantPickupAddress.getId().longValue());
    }


    @Test
    public void test_create_user_success() throws Exception {
        MerchantPickupAddress user = new MerchantPickupAddress(
                1, true, 4, 1, "Số nhà 178 ngõ 126 phố Không Mùa", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        when(merchantPickupAddressService.exists(user)).thenReturn(false);

        doNothing().when(merchantPickupAddressService).save(user);
        mockMvc.perform(
                post("/pickup_address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/pickup_address")));
        verify(merchantPickupAddressService, times(1)).exists(user);

        verify(merchantPickupAddressService, times(1)).save(user);

        verifyNoMoreInteractions(merchantPickupAddressService);
    }


    /*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<MerchantPickupAddress> buildMerchantPickupAddress() {
        MerchantPickupAddress merchantPickupAddress1 = new MerchantPickupAddress(
                1, true, 4, 1, "Số nhà 178 ngõ 126 phố Không Mùa", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        MerchantPickupAddress merchantPickupAddress2 = new MerchantPickupAddress(
                2, true, 5, 1, "Số nhà 178 ngõ 126 phố Không Mùa", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        List<MerchantPickupAddress> pickupAddressList = Arrays.asList(merchantPickupAddress1, merchantPickupAddress2);
        return pickupAddressList;
    }
}
