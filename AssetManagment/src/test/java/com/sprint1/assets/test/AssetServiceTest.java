package com.sprint1.assets.test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;
import com.sprint1.assets.model.Status;
import com.sprint1.assets.repository.AssetManagementRepository;
import com.sprint1.assets.service.AssetService;

@SpringBootTest
class AssetServiceTest {

	@Autowired
	AssetService assetService;

	@MockBean
	AssetManagementRepository assetRepo;

	Asset a;

	@BeforeEach
	public void setUp() throws Exception {
		a = getAsset();
	}

	private Asset getAsset() {
		Asset a1 = new Asset();
		a1.setAssetId(101);
		a1.setRecipientName("Venu");
		a1.setRecipientLocation("Mysuru");
		a1.setAssetManufacturer("Lenovo");
		a1.setAssetModel("Thinkpad");
		a1.setAssetType("Laptop");
		a1.setAssetStatus(Status.READY_TO_DELIVER);
		a1.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a1.setExpectedDeliveryDate(LocalDate.of(2022, 04, 05));
		a1.setActualDeliveredDate(LocalDate.of(2022, 04, 05));
		a1.setAssetSourceLocation("Bengaluru");
		a1.setAssetDestinationLocation("Mysuru");
		return a1;
	}

	@Test
	void testDeleteAsset() throws NotFoundException {
		Mockito.when(assetRepo.existsById(Mockito.anyInt())).thenReturn(true);
		assertThat(assetService.deleteAsset(Mockito.anyInt())).isEqualTo(true);
	}

	@Test
	void testModifyAsset() throws NotFoundException {
		Mockito.when(assetRepo.existsById(Mockito.anyInt())).thenReturn(true);
		Mockito.when(assetRepo.save(a)).thenReturn(a);
		Mockito.when(assetService.modifyAsset(a)).thenReturn(true);

	}
}