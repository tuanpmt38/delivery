package shippo.vn.delivery.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shippo.vn.delivery.model.MerchantPickupAddress;
import shippo.vn.delivery.repository.MerchantPickupAddressRepository;
import shippo.vn.delivery.services.MerchantPickupAddressService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
public class MerchantPickupAddressServiceTest {

    @Mock
    private MerchantPickupAddressService merchantPickupAddressService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public MerchantPickupAddressRepository merchantPickupAddressRepository() {
        return Mockito.mock(MerchantPickupAddressRepository.class);
    }

    @Test
    public void testGetAllMerchantPickupAddress() {

        List<MerchantPickupAddress> merchantPickupAddressList = new ArrayList<MerchantPickupAddress>();
        merchantPickupAddressList.add(new MerchantPickupAddress(
                1, true, 4, 1, "Số nhà 178 ngõ 126 phố", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        ));
        merchantPickupAddressList.add(new MerchantPickupAddress(
                2, true, 4, 1, "Số nhà 178 ngõ 126 phố", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        ));
        merchantPickupAddressList.add(new MerchantPickupAddress(
                3, true, 4, 1, "Số nhà 178 ngõ 126 phố", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        ));
        when(merchantPickupAddressService.findAll()).thenReturn(merchantPickupAddressList);
        List<MerchantPickupAddress> result = merchantPickupAddressService.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetMerchantPickupAddressId() {

        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress(
                1, true, 4, 1, "Số nhà 178 ngõ 126 phố", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        when(merchantPickupAddressService.findById(1)).thenReturn(java.util.Optional.of(merchantPickupAddress));
        Integer result = merchantPickupAddress.getId();
        assertEquals(1, result.intValue());
    }

    @Test
    public void removeMerchantPickupAddress() {

        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress(
                10, true, 4, 1, "Số nhà 178 ngõ 126 phố", "Lương Thanh Lâm", "0912310570", "Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội", 9,
                "null", 99, null, null
        );
        merchantPickupAddressService.delete(merchantPickupAddress.getId());
        verify(merchantPickupAddressService, times(1)).delete(1);
    }

    @Test
    public void saveMerchantPickupAddress() {
        MerchantPickupAddress merchantPickupAddress = new MerchantPickupAddress ();
        merchantPickupAddress.setId(8);
        merchantPickupAddress.setIsDeleted(true);
        merchantPickupAddress.setCreatedBy(4);
        merchantPickupAddress.setMerchantId(1);
        merchantPickupAddress.setDetailAddress("Số nhà 178 ngõ 126 phố");
        merchantPickupAddress.setContactName("Luong Van Thang");
        merchantPickupAddress.setContactPhone("0168266999");
        merchantPickupAddress.setFullAddress("Số nhà 287 ngõ 115 phố Nguyễn Xiển, Đống Đa, Hà Nội");
        merchantPickupAddress.setLocationIdsPath(9);
        merchantPickupAddress.setLocationNamesPath("");
        merchantPickupAddress.setVersion(99);
        merchantPickupAddress.setCreatedAt(null);
        merchantPickupAddress.setUpdatedAt(null);

        Mockito.when(merchantPickupAddressRepository().save(merchantPickupAddress)).thenReturn(merchantPickupAddress);
    }



}
