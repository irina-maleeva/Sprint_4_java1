package ru.praktikum.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.selenium.data.TestData;

import java.time.Duration;
import java.util.Random;

public class OrderPage {
    WebDriver webDriver;
    int random = new Random().nextInt(6);

    private By formHeading = By.xpath(".//div[text()='Для кого самокат']");
    private By nameInputField = By.xpath(".//input[@placeholder='* Имя']");
    private By familyNameInputField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationInputField = By.xpath(".//input[@placeholder='* Станция метро']");

    private By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By submitButton = By.xpath(".//button[text()= 'Далее']");
    private By detailsFormHeading = By.xpath(".//div[text()='Про аренду']");
    private By dateInputField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentDurationDropdownOptions = By.xpath(".//div[@class='Dropdown-option']");
    private By rentDurationInputField = By.xpath(".//div[@class='Dropdown-root']");
    private By blackColorCheckbox = By.id("black");
    private By greyColorCheckbox = By.id("grey");
    private By commentInputField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderCreatedMessage = By.xpath(".//div[text()='Заказ оформлен']");

    private By yesButton = By.xpath(".//button[text()='Да']");

    public void waitForPageLoad(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(formHeading));
    }

    public void fillFirstFormFields(TestData testData) {
        webDriver.findElement(nameInputField).sendKeys(testData.name);
        webDriver.findElement(familyNameInputField).sendKeys(testData.familyName);
        webDriver.findElement(addressInputField).sendKeys(testData.address);
        webDriver.findElement(metroStationInputField).sendKeys(testData.metro);
        webDriver.findElement(metroStationInputField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        webDriver.findElement(phoneInputField).sendKeys(testData.phone);
    }
    public void clickSubmitButton(){
        webDriver.findElement(submitButton).click();
    }
    public void waitForDetailsFormLoad(){
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(detailsFormHeading));
    }
    public void chooseDate(String date){
        webDriver.findElement(dateInputField).sendKeys(date);
        webDriver.findElement(dateInputField).sendKeys(Keys.ENTER);
    }

    public void chooseRentDuration(){
        webDriver.findElement(rentDurationInputField).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(rentDurationDropdownOptions));
        webDriver.findElements(rentDurationDropdownOptions).get(random).click();
    }
    public void chooseGreyColor(){
        webDriver.findElement(greyColorCheckbox).click();
    }
    public void chooseBlackColor(){
        webDriver.findElement(blackColorCheckbox).click();
    }
    public void writeComment(String comment){
        webDriver.findElement(commentInputField).sendKeys(comment);
    }
    public void clickOrderButton(){
        webDriver.findElement(orderButton).click();
    }
    public void waitConfirmation(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(orderCreatedMessage));
    }
    public String getConfirmationHeadingText(){
        String text = webDriver.findElement(orderCreatedMessage).getText();
        return text;
    }

    public void clickYesButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        webDriver.findElement(yesButton).click();
    }
}
