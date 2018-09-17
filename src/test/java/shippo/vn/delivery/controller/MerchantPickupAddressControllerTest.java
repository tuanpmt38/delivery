package shippo.vn.delivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import shippo.vn.delivery.model.DeliveryOrderFee;
import shippo.vn.delivery.model.MerchantPickupAddress;
import shippo.vn.delivery.services.MerchantPickupAddressService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(MerchantPickupAddressController.class)
public class MerchantPickupAddressControllerTest {

    private static final int UNKNOWN_ID = Integer.MAX_VALUE;

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

    private final String URL = "/pickup_address";

    @Test
    public void testGetMerchantPickupAddressById() throws Exception {

        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress(
                1, true, 3, 1, "Số nhà 178 ngõ 126 phố Không Mùa", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        when(merchantPickupAddressService.findById(1)).thenReturn(Optional.of(merchantPickupAddress));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(URL + "/" + "{id}", new Integer(1)).accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

        // verify that services method was called once.
        verify(merchantPickupAddressService).findById(any(Integer.class));

        MerchantPickupAddress resultMerchantPickupAddress = TestUtils.jsonToObject(result.getResponse().getContentAsString(), MerchantPickupAddress.class);
        assertNotNull(resultMerchantPickupAddress);
        assertEquals(1l, resultMerchantPickupAddress.getId().intValue());
    }

    @Test
    public void testGetMerchantPickupAddressByIdNotExist() throws Exception {

        // execute
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(URL + "/" + "{id}", new Long(1)).accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND.value(), status);

        // verify that service method was called once
        verify(merchantPickupAddressService).findById(any(Integer.class));

        MerchantPickupAddress resultEmployee = TestUtils.jsonToObject(result.getResponse().getContentAsString(), MerchantPickupAddress.class);
        assertNull(resultEmployee);
    }

    @Test
    public void testGetAllMerchantPickupAddress() throws Exception {

        // prepare data and mock's behaviour
        List<MerchantPickupAddress> merchantPickupAddressList = buildMerchantPickupAddress();
        when(merchantPickupAddressService.findAll()).thenReturn(merchantPickupAddressList);

        // execute
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

        verify(merchantPickupAddressService).findAll();

    }

    @Test
    public void testUpdateMerchantPickupAddress() throws Exception {

        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress(
                1, true, 4, 1, "Số nhà 178 ngõ 126 phố", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        when(merchantPickupAddressService.findById(1)).thenReturn(Optional.of(merchantPickupAddress));

        mockMvc.perform(
                put(URL+"/"+"{id}", merchantPickupAddress.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.asJsonString(merchantPickupAddress)))
                .andExpect(status().isOk());

        verify(merchantPickupAddressService, times(1)).findById(merchantPickupAddress.getId());
        verify(merchantPickupAddressService, times(1)).save(merchantPickupAddress);
        verifyNoMoreInteractions(merchantPickupAddressService);

    }

    @Test
    public void testDeleteMerchantPickupAddress() throws Exception {

        // prepare data and mock's behaviour
        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress(1);
        when(merchantPickupAddressService.findById(any(Integer.class))).thenReturn(Optional.of(merchantPickupAddress));
        doNothing().when(merchantPickupAddressService).delete(merchantPickupAddress.getId());
        // execute
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/" + "{id}", new Integer(1))).andReturn();

        mockMvc.perform(
                delete("/pickup_address/{id}", merchantPickupAddress.getId()))
                .andExpect(status().isOk());

        verify(merchantPickupAddressService, times(1)).findById(merchantPickupAddress.getId());
        verify(merchantPickupAddressService, times(1)).delete(merchantPickupAddress.getId());
        verifyNoMoreInteractions(merchantPickupAddressService);

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
