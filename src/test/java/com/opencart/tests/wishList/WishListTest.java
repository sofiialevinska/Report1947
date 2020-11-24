package com.opencart.tests.wishList;

import com.opencart.datamodel.LoginModel;
import com.opencart.navigation.Navigation;
import com.opencart.pages.HeaderPage;
import com.opencart.repository.LoginModelRepository;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.steps.WishListPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class WishListTest extends BaseTest {

    @Test
    public void addSomethingInWishListWithoutLogin() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL.getHeaderPageBL()
        .clickOnMacbookWishListButton();
        mainPageBL.getHeaderPageBL()
        .verifyAddingMacbookToWishListWithoutLogin();
    }

    @Test
    public void addSomethingInWishListWithLogin() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        HeaderPageBL headerPageBL = new HeaderPageBL();
        LoginModel loginModel = LoginModelRepository.getValidLoginModel();
        mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel)
                .clickOnYourStoreButton();
        headerPageBL.clickOnMacbookWishListButton()
                .verifyAddingMacbookInWishListWithLogin();
    }

    @Test
    public void deleteProductFromWishList() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginModel loginModel = LoginModelRepository.getValidLoginModel();
        mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel)
                .clickOnYourStoreButton()
                .clickOnMacbookWishListButton()
                .clickOnWishListButton()
                .clickOnRemoveButton()
                .verifyDeletingFromWishList();
    }

    @Test
    public void addProductToShoppingCart() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginModel loginModel = LoginModelRepository.getValidLoginModel();
        mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel)
                .clickOnYourStoreButton()
                .clickOnMacbookWishListButton()
                .clickOnWishListButton()
                .clickOnAddToCartButton()
                .verifyAddingToShoppingCart();
        new WishListPageBL().clickOnRemoveButton();
    }

    @Test
    public void checkWishListValueAfterAddingInWishList() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        HeaderPageBL headerPageBL = new HeaderPageBL();
        mainPageBL.getHeaderPageBL()
                .clickOnMacbookWishListButton();
        headerPageBL.verifyChangingOfValueInWishList();
    }

    @Test
    public void addAllProductsFromMainPageToWishList() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        HeaderPageBL headerPageBL = new HeaderPageBL();
    }
}
